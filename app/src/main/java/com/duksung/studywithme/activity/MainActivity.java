package com.duksung.studywithme.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.duksung.studywithme.R;

public class MainActivity extends AppCompatActivity {

    TextView tv_searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_searchBar = findViewById(R.id.tv_searchBar);

        tv_searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                overridePendingTransition(R.anim.fade_in, R.anim.not_move); // 화면전환 애니메이션
                startActivity(intent);
            }
        });


    }
}