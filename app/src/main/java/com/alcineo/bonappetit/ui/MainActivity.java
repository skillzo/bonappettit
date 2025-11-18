package com.alcineo.bonappetit.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.alcineo.bonappetit.R;
import com.alcineo.bonappetit.domain.SoftposInitialization;
import java.util.Observable;

public class MainActivity extends AppCompatActivity {

    public  Observable      softposInitializationObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_main);
        softposInitializationObservable = new SoftposInitialization(this, getApplicationContext(), this.getWindow());
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().clearFlags(android.view.WindowManager.LayoutParams.FLAG_SECURE);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}