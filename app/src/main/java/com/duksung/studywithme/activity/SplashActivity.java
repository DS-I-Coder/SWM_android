package com.duksung.studywithme.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.duksung.studywithme.R;
import com.duksung.studywithme.common.preferences.AppData;

// 처음 실행시 보여지는 액티비티
public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_splash_login, btn_splash_register;
    LinearLayout layout_bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        btn_splash_login = findViewById(R.id.btn_splash_login);
        btn_splash_register = findViewById(R.id.btn_splash_register);
        layout_bottom = findViewById(R.id.layout_bottom);

        btn_splash_login.setOnClickListener(this);
        btn_splash_register.setOnClickListener(this);

        startLoading();
    }

    private void startLoading(){
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                layout_bottom.setVisibility(View.VISIBLE);
                checkLogin();
            }
        }, 1500);
    }

    private void checkLogin(){
        // 로그인 유지.
        AppData appData = AppData.getInstance(getApplicationContext());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_splash_login){          //로그인 버튼
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
        }
        else if (v.getId() == R.id.btn_splash_register){ // 회원가입 버튼
            Intent intent = new Intent(getApplicationContext(), RegisterStep1Activity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
        }
    }
}