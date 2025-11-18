package com.alcineo.bonappetit.domain;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.Window;
import android.os.Looper;

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
    private static final String LOG_SEPARATOR = "========== %s ==========";
    private              boolean isDeviceReady;

    /**
     * Initialization process
     * Tasks are ordered and should not be reorganized
     */
    public SoftposInitialization(Activity activity, Context context, Window window) {
        Log.i(TAG, String.format(LOG_SEPARATOR, "SOFTPOS INITIALIZATION START"));
        logThreadInfo("Constructor");
        Log.i(TAG, "Activity: " + (activity != null ? activity.getClass().getSimpleName() : "NULL"));
        Log.i(TAG, "Context: " + (context != null ? context.getClass().getSimpleName() : "NULL"));
        Log.i(TAG, "Window: " + (window != null ? "Available" : "NULL"));
        
        new Thread(() -> {
            Log.i(TAG, String.format(LOG_SEPARATOR, "INITIALIZATION THREAD STARTED"));
            logThreadInfo("Initialization thread");

            // Step 1: Connectivity Check
            Log.i(TAG, String.format(LOG_SEPARATOR, "STEP 1: CONNECTIVITY CHECK"));
            try {
                new ConnectivityCheck();
                Log.i(TAG, "✓ Connectivity check passed");
            } catch (Exception e) {
                Log.e(TAG, "❌ Connectivity check failed: " + e.getMessage(), e);
                throw new RuntimeException(e);
            }

            // Step 2: Hardware Check
            Log.i(TAG, String.format(LOG_SEPARATOR, "STEP 2: HARDWARE CHECK"));
            try {
                new HardwareCheck(context);
                Log.i(TAG, "✓ Hardware check passed");
            } catch (RuntimeException e) {
                Log.e(TAG, "❌ Hardware check failed: " + e.getMessage(), e);
                if (e.getMessage() != null && e.getMessage().contains("NFC")) {
                    Log.e(TAG, "NFC hardware issue detected");
                    activity.runOnUiThread(() -> activity.setContentView(R.layout.view_nfc_not_available));
                    return; // stop further initialization
                } else {
                    throw e; // rethrow any other runtime errors
                }
            }

            // Step 3: NFC Check
            Log.i(TAG, String.format(LOG_SEPARATOR, "STEP 3: NFC CHECK"));
            try {
                new NfcCheck(context);
                Log.i(TAG, "✓ NFC check passed - NFC is ready");
            } catch (RuntimeException e) {
                Log.e(TAG, "❌ NFC check failed: " + e.getMessage(), e);
                throw e;
            }

            // Step 4: Security Initialization
            Log.i(TAG, String.format(LOG_SEPARATOR, "STEP 4: SECURITY INITIALIZATION"));
            try {
                String samServer = "https://e2fb8efb-sdk-sam.prod.alcineo.io:443";
                String sdkServer = "https://e2fb8efb-sdk.prod.alcineo.io:9001";
                int timeout = 60000;
                
                Log.i(TAG, "Initializing AttestationAgent:");
                Log.i(TAG, "  - SAM Server: " + samServer);
                Log.i(TAG, "  - SDK Server: " + sdkServer);
                Log.i(TAG, "  - Timeout: " + timeout + "ms");
                
                AttestationAgent.init(context, samServer, sdkServer, timeout);
                Log.i(TAG, "✓ AttestationAgent initialized");

                Log.i(TAG, "Initializing SecurityAPI...");
                SecurityAPI.initialize(activity, error -> {
                    Log.e(TAG, "❌ System error, SDK is closed: " + error);
                });
                Log.i(TAG, "✓ SecurityAPI initialized");
                
            } catch (Exception e) {
                Log.e(TAG, String.format(LOG_SEPARATOR, "SECURITY INITIALIZATION FAILED"));
                Log.e(TAG, "❌ FATAL error during security initialization");
                Log.e(TAG, "Exception type: " + e.getClass().getSimpleName());
                Log.e(TAG, "Exception message: " + e.getMessage());
                Log.e(TAG, "Stack trace:", e);
                throw new RuntimeException(e);
            }
            
            // Step 5: SoftPOS SDK Initialization
            Log.i(TAG, String.format(LOG_SEPARATOR, "STEP 5: SOFTPOS SDK INITIALIZATION"));
            try {
                Log.i(TAG, "Initializing SoftposAPI...");
                SoftposAPI.initialize(activity);
                Log.i(TAG, "✓ SoftposAPI initialized");
            } catch (Exception e) {
                Log.e(TAG, "❌ SoftposAPI initialization failed: " + e.getMessage(), e);
                throw new RuntimeException(e);
            }

            // Step 6: Pinpad Initialization
            Log.i(TAG, String.format(LOG_SEPARATOR, "STEP 6: PINPAD INITIALIZATION"));
            try {
                Log.i(TAG, "Initializing PinpadAPI...");
                PinpadAPI.initialize(context);
                Log.i(TAG, "✓ PinpadAPI initialized");
            } catch (Exception e) {
                Log.e(TAG, "❌ PinpadAPI initialization failed: " + e.getMessage(), e);
                throw new RuntimeException(e);
            }

            // Step 7: Clear secure window flag
            Log.i(TAG, String.format(LOG_SEPARATOR, "STEP 7: WINDOW CONFIGURATION"));
            activity.runOnUiThread(() -> {
                activity.getWindow().clearFlags(android.view.WindowManager.LayoutParams.FLAG_SECURE);
                Log.i(TAG, "✓ Window secure flag cleared");
            });

            // Step 8: Enrollment
            Log.i(TAG, String.format(LOG_SEPARATOR, "STEP 8: DEVICE ENROLLMENT"));
            try {
                new Enrollment();
                Log.i(TAG, "✓ Enrollment completed");
            } catch (Exception e) {
                Log.e(TAG, "❌ Enrollment failed: " + e.getMessage(), e);
                throw new RuntimeException(e);
            }

            // Step 9: Load Terminal Settings
            Log.i(TAG, String.format(LOG_SEPARATOR, "STEP 9: LOAD TERMINAL SETTINGS"));
            try {
                new LoadTerminalSettingsExample(context);
                Log.i(TAG, "✓ Terminal settings loaded");
            } catch (Exception e) {
                Log.e(TAG, "❌ Failed to load terminal settings: " + e.getMessage(), e);
                throw new RuntimeException(e);
            }

            // Step 10: RKI Key Injection
            Log.i(TAG, String.format(LOG_SEPARATOR, "STEP 10: RKI KEY INJECTION"));
            try {
                RkiExample.tr34IMEAKInjection();
                Log.i(TAG, "✓ RKI key injection completed");
            } catch (Exception e) {
                Log.e(TAG, "❌ RKI key injection failed: " + e.getMessage(), e);
                throw new RuntimeException(e);
            }

            // Step 11: Device Check
            Log.i(TAG, String.format(LOG_SEPARATOR, "STEP 11: DEVICE CHECK"));
            try {
                new DeviceCheck();
                Log.i(TAG, "✓ Device check completed");
            } catch (Exception e) {
                Log.e(TAG, "❌ Device check failed: " + e.getMessage(), e);
                throw new RuntimeException(e);
            }

            // Step 12: Audit Log
            Log.i(TAG, String.format(LOG_SEPARATOR, "STEP 12: AUDIT LOG"));
            try {
                new AuditLogExample();
                Log.i(TAG, "✓ Audit log initialized");
            } catch (Exception e) {
                Log.e(TAG, "❌ Audit log initialization failed: " + e.getMessage(), e);
                throw new RuntimeException(e);
            }

            // Final Summary
            Log.i(TAG, String.format(LOG_SEPARATOR, "INITIALIZATION SUMMARY"));
            try {
                byte[] deviceUid = DeviceInfoAPI.getDeviceUid();
                String sdkVersion = SoftposPropertiesAPI.getSoftposLibraryVersion();
                String serverHostname = AttestationAgent.getServerHostname();
                
                Log.i(TAG, "✓ Device UID: " + (deviceUid != null ? StringUtils.convertBytesToHex(deviceUid) : "NULL"));
                Log.i(TAG, "✓ Server hostname: " + (serverHostname != null ? serverHostname : "NULL"));
                Log.i(TAG, "✓ SoftPOS library version: " + (sdkVersion != null ? sdkVersion : "NULL"));
                Log.i(TAG, "✓ Android version: " + Build.VERSION.SDK_INT);
                Log.i(TAG, "✓ Security patch: " + Build.VERSION.SECURITY_PATCH.replaceAll("-", ""));
            } catch (Exception e) {
                Log.e(TAG, "❌ Failed to get initialization summary: " + e.getMessage(), e);
            }

            Log.i(TAG, String.format(LOG_SEPARATOR, "INITIALIZATION COMPLETE"));
            setChanged();
            isDeviceReady = true;
            notifyObservers(true);
            Log.i(TAG, "✓ Device is ready for transactions");
        }).start();
    }

    public boolean isDeviceReady() {
        return isDeviceReady;
    }
    
    // Helper method to log thread information
    private void logThreadInfo(String methodName) {
        Thread currentThread = Thread.currentThread();
        boolean isMainThread = Looper.getMainLooper().getThread() == currentThread;
        Log.i(TAG, "Thread: " + currentThread.getName() + 
              (isMainThread ? " (MAIN)" : " (BACKGROUND)") + 
              " | Method: " + methodName);
    }

}
