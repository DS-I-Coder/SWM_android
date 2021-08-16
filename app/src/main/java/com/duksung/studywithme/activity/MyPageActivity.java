package com.duksung.studywithme.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duksung.studywithme.R;
import com.duksung.studywithme.adapter.StudyRecordAdapter;
import com.duksung.studywithme.model.StudyRecordModel;

import java.util.ArrayList;

public class MyPageActivity extends AppCompatActivity {
    TextView tv_my_study_room;
    RecyclerView rc_studyrecord;
    StudyRecordAdapter studyRecordAdapter;
    private ArrayList<StudyRecordModel> mStudyRecords;

    LinearLayout layout_edit_password;
    TextView tv_edit_password;
    Button btn_mypage_cancel;
    ImageView iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        //뒤로가기 이미지
        iv_back=findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        //공부량 recyclerview
        studyRecordAdapter=new StudyRecordAdapter();
        rc_studyrecord=findViewById(R.id.rc_studyrecord);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rc_studyrecord.setLayoutManager(manager);
        rc_studyrecord.setAdapter(studyRecordAdapter);


        mStudyRecords=new ArrayList<>();
        mStudyRecords.add(new StudyRecordModel("TODAY 공부량"));
        mStudyRecords.add(new StudyRecordModel("이 달의 공부량"));

        studyRecordAdapter.setRecordList(mStudyRecords);


        //비밀번호 수정
        layout_edit_password=findViewById(R.id.layout_edit_password);
        tv_edit_password=findViewById(R.id.tv_edit_password);

        tv_edit_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(layout_edit_password.getVisibility()==view.GONE){
                    layout_edit_password.setVisibility(view.VISIBLE);
                }
            }
        });

        //취소 버튼 누르면 메인으로
        btn_mypage_cancel=findViewById(R.id.btn_mypage_cancel);
        btn_mypage_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}