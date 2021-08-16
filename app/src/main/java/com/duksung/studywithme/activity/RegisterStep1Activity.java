package com.duksung.studywithme.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.duksung.studywithme.R;
import com.duksung.studywithme.common.Common;

public class RegisterStep1Activity extends AppCompatActivity {
    private Button btn_nickname, btn_register;
    private EditText et_nickname, et_registerId, et_registerPassword, et_checkRegisterPassword;
    private TextView tv_alertExistNickname;
    private Boolean isCheckedNickname = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_step1);

        et_nickname = findViewById(R.id.et_nickname);
        et_registerId = findViewById(R.id.et_registerId);
        et_registerPassword = findViewById(R.id.et_registerPassword);
        et_checkRegisterPassword = findViewById(R.id.et_checkRegisterPassword);
        btn_register = findViewById(R.id.btn_register);


        btn_nickname.setOnClickListener(new View.OnClickListener() { // 닉네임 중복확인
            @Override
            public void onClick(View v) {
                checkNickname();
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() { // 회원가입 버튼
            @Override
            public void onClick(View v) {
                if(!isCheckedForm()){

                }else {
                    //TODO 회원가입 가능. 서버에 내용 전송

                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void checkNickname(){
        String nickname = et_nickname.getText().toString();
        if (Common.isStringEmpty(nickname)){
            Toast.makeText(getApplicationContext(), "닉네임을 입력하세요.", Toast.LENGTH_SHORT).show();
        }
        else{
            //TODO 서버에 닉네임 보내서 확인

            //중복이라면
            tv_alertExistNickname.setVisibility(View.VISIBLE);
            isCheckedNickname = false;

            //중복이 아니라면
            tv_alertExistNickname.setVisibility(View.INVISIBLE);
            isCheckedNickname = true;
        }
    }

    private Boolean isCheckedForm(){
        String password = et_registerPassword.getText().toString();
        String checkPassword = et_checkRegisterPassword.getText().toString();

        if (password.equals(checkPassword)){
            Toast.makeText(getApplicationContext(), "비밀번호를 정확히 입력하세요.", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (Common.isStringEmpty(et_registerId.getText().toString())
            || Common.isStringEmpty(password)
            || Common.isStringEmpty(checkPassword)
            || Common.isStringEmpty(et_nickname.getText().toString()
        )){
            Toast.makeText(getApplicationContext(), "내용을 전부 입력해주세요.", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

}