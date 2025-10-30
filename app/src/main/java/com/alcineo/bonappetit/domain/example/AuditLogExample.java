package com.alcineo.bonappetit.domain.example;

import android.util.Log;

import com.alcineo.softpos.security.api.AuditLogAPI;
import com.alcineo.softpos.security.error.AuditLogException;
import com.alcineo.softpos.security.model.auditlog.AuditLogEventStatus;
import com.alcineo.softpos.security.model.auditlog.AuditLogEventType;
import com.alcineo.softpos.security.model.auditlog.AuditLogWriteEventOrigin;

/**
 * Class who demonstrate how to add a line in audit log files.
 * <p>An {@link AuditLogEventType} represents the type of the event
 * <p>An {@link AuditLogEventStatus} represents the status of the event (SUCCESS/FAILED)
 * <p>An {@link AuditLogWriteEventOrigin} represents the origin of the event
 */
public class AuditLogExample {

    private static final String TAG = AuditLogExample.class.getSimpleName();
    private static final String EXAMPLE_OF_AUDITLOG_MESSAGE = "This is an example audit log message that will be inserted to audit log files.";
    private static final AuditLogEventType EVENT_TYPE = AuditLogEventType.ATTESTATION;
    private static final AuditLogEventStatus EVENT_STATUS = AuditLogEventStatus.FAILED;
    private static final AuditLogWriteEventOrigin EVENT_ORIGIN = AuditLogWriteEventOrigin.APPLICATION;


    public AuditLogExample() {

        try {
            AuditLogAPI.newAuditLogLine(EVENT_TYPE, EVENT_STATUS, EVENT_ORIGIN, EXAMPLE_OF_AUDITLOG_MESSAGE);
        } catch (AuditLogException e) {
            Log.e(TAG, e.getMessage());
        }

        //Tests all signatures in audit logs.
        //This call should take time if the audit log is big.
        //The application developer will take care to call it at relevant time.
        boolean isCorrectSignature = AuditLogAPI.isCorrectAuditLogSignatures();
        Log.d(TAG, " isCorrectAuditLogSignatures isCorrectSignature = " + isCorrectSignature);
    }

}
