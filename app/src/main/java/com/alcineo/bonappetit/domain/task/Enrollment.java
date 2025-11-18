package com.alcineo.bonappetit.domain.task;

import android.util.Log;
import android.os.Looper;

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
    private static final String LOG_SEPARATOR = "========== %s ==========";

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
        Log.i(TAG, String.format(LOG_SEPARATOR, "ENROLLMENT PROCESS START"));
        logThreadInfo("Enrollment");
        
        AttestationRequestException enrollmentException = null;
        // As say in Integration Security Guide,
        // before Enrollement and UpdateInitialSessionKeyAPI inject entropy in library

        Log.i(TAG, "Checking enrollment status...");
        try {
            Log.i(TAG, "Attempting to update initial session key...");
            UpdateInitialSessionKeyAPI.updateInitSessionKey();
            Log.i(TAG, "✓ Update initial session key successful - Device already enrolled");
            Log.i(TAG, "✓ Enrollment check complete - Device is enrolled");
        } catch (AttestationRequestException ex) {
            Log.w(TAG, "⚠️ Update initial session key failed");
            logThreadInfo("Enrollment exception handler");
            Log.w(TAG, "Exception type: " + ex.getClass().getSimpleName());
            Log.w(TAG, "Exception message: " + ex.getMessage());
            
            if (ex != null) {
                AttestationResponseCodeEnum responseCode = ex.getAttestationResponseCodeEnum();
                Log.i(TAG, "Response code: " + (responseCode != null ? responseCode.toString() : "NULL"));
                
                //if enrollment failed because already enrolled call update init session key
                if (responseCode == AttestationResponseCodeEnum.SERVER_DUID_NOT_ENROLLED) {
                    Log.i(TAG, "Device is NOT enrolled - Starting new enrollment...");
                    try {
                        Log.i(TAG, "Calling EnrollmentAPI.newEnrollment()...");
                        EnrollmentAPI.newEnrollment();
                        Log.i(TAG, "✓ New enrollment successful");
                        Log.i(TAG, "✓ Device enrolled successfully");
                    } catch (AttestationRequestException e) {
                        Log.e(TAG, String.format(LOG_SEPARATOR, "ENROLLMENT FAILED"));
                        Log.e(TAG, "❌ New enrollment failed");
                        logThreadInfo("Enrollment newEnrollment exception");
                        Log.e(TAG, "Exception type: " + e.getClass().getSimpleName());
                        Log.e(TAG, "Exception message: " + e.getMessage());
                        Log.e(TAG, "Error code: " + (e.getErrorCode() != null ? e.getErrorCode() : "NULL"));
                        Log.e(TAG, "Error code (bytes): " + (e.getErrorCodeByteArray() != null ? StringUtils.convertBytesToHex(e.getErrorCodeByteArray()) : "NULL"));
                        Log.e(TAG, "Error reason: " + (e.getReason() != null ? e.getReason() : "NULL"));
                        Log.e(TAG, "Stack trace:", e);
                        throw e;
                    }
                } else {
                    Log.w(TAG, "⚠️ Enrollment check failed with different error code: " + responseCode);
                    Log.w(TAG, "Error code: " + (ex.getErrorCode() != null ? ex.getErrorCode() : "NULL"));
                    Log.w(TAG, "Error reason: " + (ex.getReason() != null ? ex.getReason() : "NULL"));
                }
            }
        } catch (Exception e) {
            Log.e(TAG, String.format(LOG_SEPARATOR, "ENROLLMENT EXCEPTION"));
            Log.e(TAG, "❌ Unexpected exception during enrollment");
            logThreadInfo("Enrollment unexpected exception");
            Log.e(TAG, "Exception type: " + e.getClass().getSimpleName());
            Log.e(TAG, "Exception message: " + e.getMessage());
            Log.e(TAG, "Stack trace:", e);
            throw new RuntimeException(e);
        }

        Log.i(TAG, String.format(LOG_SEPARATOR, "ENROLLMENT PROCESS COMPLETE"));
        Log.i(TAG, "✓ Enrollment finished successfully");
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