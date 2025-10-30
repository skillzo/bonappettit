package com.alcineo.bonappetit.domain.example;

import android.util.Log;

import com.alcineo.softpos.security.api.PaymentRkiAPI;
import com.alcineo.softpos.security.error.InjectKeyException;
import com.alcineo.softpos.security.model.InjectionTR34_TR31Listener;
import com.alcineo.softpos.security.model.KeyId;
import com.alcineo.utils.common.StringUtils;

/**
 * Before the first transaction you need to inject keys for payment and pinpad module. RkiExample
 * implementation present in BonAppetit application example is for demo purpose. In a real
 * Sales Application, the methods within should be call once before the first transaction to allow the
 * encryption of the sensitive data and the Online PIN processing.
 */
public class RkiExample {

    private static final String TAG         = RkiExample.class.getSimpleName();

    static long timing = 0;
    static long last = 0;

    public static void tr34IMEAKInjection() {
        Log.i(TAG, "Start key injection");

        try {
            byte[] cred_kdh = AWSPaymentCryptoExample.getCredKdh();
            timing = 0;
            last = System.currentTimeMillis();
            PaymentRkiAPI.startTR34KeyInjection(KeyId.IMEAK, true, cred_kdh, new InjectionTR34_TR31Listener() {

                @Override
                public void sendCSR(byte[] krdCSR) {
                    // send CRS to autority for generate Cred_KRD and send it on KDH.
                    Log.i(TAG, "CSR krd : "  + StringUtils.convertBytesToHex(krdCSR));

                    timing += (System.currentTimeMillis() - last);
                    AWSPaymentCryptoExample.sendKrdCsr(krdCSR);
                    last = System.currentTimeMillis();

                }

                @Override
                public TR34_TR31_keys getKeys(byte[] randomToken) {

                    timing += (System.currentTimeMillis() - last);
                    byte[] tr34Block = AWSPaymentCryptoExample.getTR34(randomToken);
                    byte[] tr31Block = AWSPaymentCryptoExample.getDukptFromTR31();
                    last = System.currentTimeMillis();

                    Log.i(TAG, "tr34 bloc : \n " + StringUtils.convertBytesToHex(tr34Block));
                    Log.i(TAG, "tr31 bloc : \n " + StringUtils.convertBytesToHex(tr31Block));
                    return new TR34_TR31_keys(tr34Block, tr31Block);
                }
            });

            PaymentRkiAPI.startTR34KeyInjection(KeyId.IPEK, true, cred_kdh, new InjectionTR34_TR31Listener() {

                @Override
                public void sendCSR(byte[] krdCSR) {
                    // send CRS to autority for generate Cred_KRD and send it on KDH.
                    Log.i(TAG, "CSR krd : "  + StringUtils.convertBytesToHex(krdCSR));

                    timing += (System.currentTimeMillis() - last);
                    AWSPaymentCryptoExample.sendKrdCsr(krdCSR);
                    last = System.currentTimeMillis();

                }

                @Override
                public TR34_TR31_keys getKeys(byte[] randomToken) {

                    timing += (System.currentTimeMillis() - last);
                    byte[] tr34Block = AWSPaymentCryptoExample.getTR34(randomToken);
                    byte[] tr31Block = AWSPaymentCryptoExample.getDukptFromTR31();
                    last = System.currentTimeMillis();

                    Log.i(TAG, "tr34 bloc : \n " + StringUtils.convertBytesToHex(tr34Block));
                    Log.i(TAG, "tr31 bloc : \n " + StringUtils.convertBytesToHex(tr31Block));
                    return new TR34_TR31_keys(tr34Block, tr31Block);
                }
            });

            timing += (System.currentTimeMillis() - last);
            Log.i(TAG, "Timming SDK : " + timing + " ms");
        } catch (InjectKeyException e) {
            Log.e(TAG, "Injection of keys failed : " + e.getMessage());
        }
    }

}
