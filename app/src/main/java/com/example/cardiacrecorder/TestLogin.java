package com.example.cardiacrecorder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class TestLogin extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=300;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_login);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String s1 = null;
                SharedPreferences sharedPreferences=getSharedPreferences(Login.PREFS_NAME,0);
                //SharedPreferences sharedPreferences1=getSharedPreferences(Login.PREFS_NAME,0);
                String hasLoggedIn2= sharedPreferences.getString("hasLoggedIn2",s1);
                boolean hasLoggedIn=sharedPreferences.getBoolean("hasLoggedIn",false);
                if(hasLoggedIn){
                    Intent intent1=new Intent(TestLogin.this,MainActivity.class);
                    intent1.putExtra("var",hasLoggedIn2);
                    startActivity(intent1);
                    finish();
                }
                else{
                    Intent intent=new Intent(TestLogin.this,Login.class);
                    startActivity(intent);
                    finish();
                }
            }
        },SPLASH_TIME_OUT);
    }
}