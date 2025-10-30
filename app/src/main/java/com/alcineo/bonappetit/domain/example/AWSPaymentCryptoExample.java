package com.alcineo.bonappetit.domain.example;

import android.util.Log;

import com.alcineo.utils.common.StringUtils;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Base64;

public class AWSPaymentCryptoExample {

    private static final String TAG = AWSPaymentCryptoExample.class.getSimpleName();

    static String port = "8088";
    static String baseURL = "http://al2023.dev.alcineo.io:"+ port;
    static String urlGetCredKDH = "initExport";
    static String urlSendCSRKRD = "sign_csr";
    static String getTransportKeyFromTR34 = "getTransportKeyFromTR34";
    static String getDukptKeyFromTR31 = "getDukptKeyFromTR31";
    static String getDukptKeyFromTR34 = "getDukptKeyFromTR34";


    private static String sendRequest(String resAPI, byte[] data) {
        try {
            URL url = new URL(baseURL+ "/" + resAPI);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            // Ouvrir la connexion

            // Envoyer les données
            if (data != null) {
                try (OutputStream os = connection.getOutputStream()) {
                    os.write(data);
                    os.flush();
                }
            }

            // Lire la réponse
            int responseCode = connection.getResponseCode();
            Log.i(TAG, "Response Code: " + responseCode);
            if (responseCode != 200)
                Log.i(TAG, "    Error : " + connection.getResponseMessage());

            String resultInBase64 = "";

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    resultInBase64 += line;
                }
            }

            connection.disconnect();

            Log.i(TAG, resultInBase64);
            return resultInBase64;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


    public static byte[] getCredKdh() {
        String decodedString = "";
        String result = sendRequest(urlGetCredKDH, null);

        if (result != null && !result.isEmpty())
        {
            byte[] decodedBytes = Base64.getDecoder().decode(result);
            decodedString = new String(decodedBytes);
        }
        Log.i(TAG, "cred kdh : " + decodedString);
        return decodedString.getBytes();
    }

    public static void sendKrdCsr(byte[] csrKRD) {
        sendRequest(urlSendCSRKRD, csrKRD);
    }

    public static byte[] getTR34(byte[] randomToken) {
        // random token is asn1 format as describe on documentation
        // for this specific test, send only random value (last 16 bytes)
        String server_random = StringUtils.convertBytesToHex(Arrays.copyOfRange(randomToken, randomToken.length-16 , randomToken.length));
        String requestResult = sendRequest(getTransportKeyFromTR34, server_random.getBytes());
//        String requestResult = sendRequest(getDukptKeyFromTR34, null);
        if (requestResult == null) {
            return new byte[0];
        }

        return StringUtils.convertHexToBytes(requestResult);
    }

    public static byte[] getDukptFromTR31() {
        String requestResult = sendRequest(getDukptKeyFromTR31, null);
        if (requestResult == null) {
            return new byte[0];
        }

        return requestResult.getBytes();
    }

    public static byte[] getDukptFromTR34(byte[] randomToken) {
        String server_random = StringUtils.convertBytesToHex(Arrays.copyOfRange(randomToken, randomToken.length-16, randomToken.length));
        String requestResult = sendRequest(getDukptKeyFromTR34, server_random.getBytes());
        if (requestResult == null) {
            return new byte[0];
        }

        return StringUtils.convertHexToBytes(requestResult);
    }


}
