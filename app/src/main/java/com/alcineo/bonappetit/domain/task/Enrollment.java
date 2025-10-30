package com.alcineo.bonappetit.domain.task;

import android.util.Log;

import com.alcineo.softpos.security.api.*;
import com.alcineo.softpos.security.error.AttestationRequestException;
import com.alcineo.softpos.security.model.AttestationResponseCodeEnum;
import com.alcineo.utils.common.StringUtils;

import java.io.IOException;
import java.util.Random;

/**
 * Enrollment implementation present in BonAppetit application example is for demo purpose.
 * In a real Sales Application, the methods within should be called once to register the mobile phone to the
 * Attestation Server. At each new production of the application and libraries a new enrollment must be performed.
 */
public class Enrollment {

    private static final String TAG = Enrollment.class.getSimpleName();

    /*
     * EnrollmentAPI.newEnrollment() is called to register the mobile phone to the Attestation Server.
     * If the registration fails, an exception containing the error code is thrown.
     * The error code is used to determine the reason for the failure, it is defined in the Security Features Integration Guide document.
     *
     * This exception implements 3 methods, as shown in the following code:
     * - getErrorCode() returns the error code in string.
     * - getErrorCodeByteArray() returns the error code in byte array.
     * - getReason() returns the reason for the failure, the human readable message.
     */
    public Enrollment() {
        AttestationRequestException enrollmentException = null;
        // As say in Integration Security Guide,
        // before Enrollement and UpdateInitialSessionKeyAPI inject entropy in library

        try {
            Log.d(TAG, "run: Update init ses");
            UpdateInitialSessionKeyAPI.updateInitSessionKey();
        } catch (AttestationRequestException ex) {
            Log.e(TAG, "Update init ses failed " + ex);
            //if enrollment failed because already enrolled call update init session key
            if (ex != null && ex.getAttestationResponseCodeEnum() == AttestationResponseCodeEnum.SERVER_DUID_NOT_ENROLLED) {
                try {
                    EnrollmentAPI.newEnrollment();

                } catch (AttestationRequestException e) {
                    Log.d(TAG, "doWork: " + e.toString(), e);
                    Log.d(TAG, "doWork: errorCode: " + e.getErrorCode());
                    Log.d(TAG, "doWork: errorReason: " + e.getReason());
                }
            }
        }

        Log.d(TAG, "run: Enrollment finish");
    }

}