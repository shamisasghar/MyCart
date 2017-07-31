package com.sha.mycart.rest;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sha.mycart.ForthActivity;
import com.sha.mycart.MainActivity;
import com.sha.mycart.R;

public class LogoActivity extends AppCompatActivity {

    private static int SPLASHSCREEN=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeintent=new Intent(LogoActivity.this, ForthActivity.class);
                startActivity(homeintent);
                finish();
            }
        },SPLASHSCREEN);
    }
}
