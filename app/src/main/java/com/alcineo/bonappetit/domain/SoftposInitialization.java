package com.alcineo.bonappetit.domain;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.Window;

import com.alcineo.bonappetit.R;
import com.alcineo.bonappetit.android.ConnectivityCheck;
import com.alcineo.bonappetit.android.HardwareCheck;
import com.alcineo.bonappetit.android.NfcCheck;
import com.alcineo.bonappetit.domain.example.AuditLogExample;
import com.alcineo.bonappetit.domain.task.DeviceCheck;
import com.alcineo.bonappetit.domain.task.Enrollment;
import com.alcineo.bonappetit.domain.example.LoadTerminalSettingsExample;
import com.alcineo.bonappetit.domain.example.RkiExample;
import com.alcineo.softpos.payment.api.DeviceInfoAPI;
import com.alcineo.softpos.payment.api.SoftposAPI;
import com.alcineo.softpos.payment.api.SoftposPropertiesAPI;
import com.alcineo.softpos.pinpad.api.PinpadAPI;
import com.alcineo.softpos.security.api.AttestationAgent;
import com.alcineo.softpos.security.api.SecurityAPI;
import com.alcineo.softpos.security.model.SoftposDefaultHttpCertificates;
import com.alcineo.utils.common.StringUtils;

import java.util.Arrays;
import java.util.Observable;

public class SoftposInitialization extends Observable {

    private static final String  TAG = SoftposInitialization.class.getSimpleName();
    private              boolean isDeviceReady;

    /**
     * Initialization process
     * Tasks are ordered and should not be reorganized
     */
    public SoftposInitialization(Activity activity, Context context, Window window) {
        new Thread(() -> {

            new ConnectivityCheck();
            try {
                new HardwareCheck(context);
            } catch (RuntimeException e) {
                if (e.getMessage() != null && e.getMessage().contains("NFC")) {
                    activity.runOnUiThread(() -> activity.setContentView(R.layout.view_nfc_not_available));
                    return; // stop further initialization
                } else {
                    throw e; // rethrow any other runtime errors
                }
            }
            new NfcCheck(context);

            try {
                AttestationAgent.init(context, "https://e2fb8efb-sdk-sam.prod.alcineo.io:443","https://e2fb8efb-sdk.prod.alcineo.io:9001", 60000);

                SecurityAPI.initialize(activity, error -> {
                    Log.e(TAG, "System error, sdk is closed at this step : " + error);
                });
            } catch (Exception e) {

                Log.e(TAG, "FATAL error during initialisation due to secure check: " + e.getMessage());
                throw new RuntimeException(e);
            }
            SoftposAPI.initialize(activity);
            PinpadAPI.initialize(context);

            new Enrollment();
            new LoadTerminalSettingsExample(context);
            RkiExample.tr34IMEAKInjection();
            new DeviceCheck();
            new AuditLogExample();

            Log.i(TAG,
                    "\n-----------------------------------------------------" +
                    "\nDUID: " + StringUtils.convertBytesToHex(DeviceInfoAPI.getDeviceUid()) +
                    "\nConfigured Server hostname: " + AttestationAgent.getServerHostname() +
                    "\nSoftPOS library version: " + SoftposPropertiesAPI.getSoftposLibraryVersion() +
                    String.format("\nAndroid version %s, security patch %s", android.os.Build.VERSION.SDK_INT, Build.VERSION.SECURITY_PATCH.replaceAll("-", "")) +
                    "\n--------------------------------------------------------------------------");

            setChanged();
            isDeviceReady = true;
            notifyObservers(true);
        }).start();
    }

    public boolean isDeviceReady() {
        return isDeviceReady;
    }

}
