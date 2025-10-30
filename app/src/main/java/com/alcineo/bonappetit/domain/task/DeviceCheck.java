package com.alcineo.bonappetit.domain.task;

import android.util.Log;

import com.alcineo.softpos.security.api.DeviceCheckAPI;
import com.alcineo.softpos.security.error.AttestationRequestException;
import com.alcineo.utils.common.StringUtils;
import com.google.common.io.BaseEncoding;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Optional;
import java.util.Random;


/**
 * DeviceCheck task is a task that is performed at regular intervals in order to check the conformity of the device with
 * the attestation server.
 */
public class DeviceCheck {
    public DeviceCheck() {
        try {
            final byte[] attestationID = DeviceCheckAPI.deviceCheck();
            Log.d("Attestation Id", StringUtils.convertBytesToHex(attestationID));

            byte[] random = new byte[32];
            new Random().nextBytes(random);
            JSONObject customData = new JSONObject();
            customData.put("contract ID", StringUtils.convertBytesToHex(random));

            final byte[] attestationIDJson = DeviceCheckAPI.deviceCheck(customData);
            Log.d("Attestation Id", StringUtils.convertBytesToHex(attestationIDJson));
        } catch (AttestationRequestException e) {
            Log.e("Device check", "Failed with error : " + e.getErrorCode());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

}