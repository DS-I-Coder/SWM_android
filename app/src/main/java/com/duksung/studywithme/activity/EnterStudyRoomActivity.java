package com.duksung.studywithme.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.duksung.studywithme.R;
import com.duksung.studywithme.fragment.dialog.RoomInfoDialog;

import java.util.Objects;

public class EnterStudyRoomActivity extends AppCompatActivity implements View.OnClickListener {


    private static final String TAG = "EnterStudyRoomActivity";
    Button btn_enterStudyRoom;
    ImageView img_roomCamera, img_roomMic, img_roomInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_study_room);

        img_roomCamera = findViewById(R.id.img_roomCamera);
        img_roomMic = findViewById(R.id.img_roomMic);
        img_roomInfo = findViewById(R.id.img_roomInfo);
        btn_enterStudyRoom = findViewById(R.id.btn_enterStudyRoom);

        img_roomCamera.setOnClickListener(this);
        img_roomMic.setOnClickListener(this);
        img_roomInfo.setOnClickListener(this);
        btn_enterStudyRoom.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.img_roomCamera){      // 카메라 버튼

        }
        else if (v.getId() == R.id.img_roomMic){    // 마이크 버튼

        }
        else if (v.getId() == R.id.img_roomInfo){  // 방 정보
            Log.d(TAG, "info button");

            DialogFragment roomInfoDialog = new RoomInfoDialog();
            roomInfoDialog.show(getSupportFragmentManager(), "roomInfoDialog");

        }
        else if (v.getId() == R.id.img_back){       // 뒤로가기
            finish();
        }
        else if (v.getId() == R.id.btn_enterStudyRoom){
            // 입장
        }
    }
}