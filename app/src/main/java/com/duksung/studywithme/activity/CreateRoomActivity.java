package com.duksung.studywithme.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.duksung.studywithme.R;
import com.duksung.studywithme.common.Common;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

public class CreateRoomActivity extends AppCompatActivity {


//방 생성하는 activity->아마도 새로 만든 EnterStudyroomActivity로 옮겨야 함
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_room);

        EditText et_2=findViewById(R.id.et_2);
        Button btn_1=findViewById(R.id.btn_1);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),StudyRoomActivity.class);
//                intent.putExtra("rId",et_1.getText());
                intent.putExtra("roomTitle",et_2.getText().toString());
                startActivity(intent);


            }
        });





    }
}