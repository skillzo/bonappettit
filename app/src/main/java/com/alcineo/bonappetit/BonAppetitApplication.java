package com.alcineo.bonappetit;

import android.app.Application;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.VmPolicy;
import android.provider.Settings;
import android.util.Log;

import com.alcineo.softpos.security.api.IncidentAPI;

public class BonAppetitApplication extends Application {

    private static final String TAG = BonAppetitApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        turnOnStrictModel();
    }

    private void turnOnStrictModel() {
        // StrictMode is a developer tool which detects things you might be doing by accident and brings them to your attention so you can fix them.
        // StrictMode is most commonly used to catch accidental disk or network access on the application's main thread,
        // where UI operations are received and animations take place.
        // Keeping disk and network operations off the main thread makes for much smoother, more responsive applications.
        // By keeping your application's main thread responsive, you also prevent ANR dialogs from being shown to users.
        // https://developer.android.com/reference/android/os/StrictMode
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new ThreadPolicy.Builder().detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()   // or .detectAll() for all detectable problems
                    .penaltyLog()
                    .build());

            StrictMode.setVmPolicy(new VmPolicy.Builder().detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    .penaltyDeath()
                    .build());
        }
    }
}


