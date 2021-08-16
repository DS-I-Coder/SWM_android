package com.duksung.studywithme.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.duksung.studywithme.R;
import com.duksung.studywithme.adapter.MainBestMemberAdapter;
import com.duksung.studywithme.common.preferences.AppData;
import com.duksung.studywithme.fragment.dialog.MainFloatingDialog;
import com.duksung.studywithme.model.CategoryModel;
import com.duksung.studywithme.model.MainBestMemberModel;
import com.duksung.studywithme.retrofit.RetrofitHelper;
import com.duksung.studywithme.retrofit.RetrofitService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static String TAG = "MainActivity";
    TextView tv_searchBar;
    ViewPager viewpager;
    ImageView img_profile, img_addRoom;
    FloatingActionButton floatingBtn_userInfo;
    List<MainBestMemberModel> models;
    MainBestMemberAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_searchBar = findViewById(R.id.tv_searchBar);
        viewpager = findViewById(R.id.main_viewpager);
        img_profile = findViewById(R.id.img_profile);
        img_addRoom = findViewById(R.id.img_addRoom);
        floatingBtn_userInfo = findViewById(R.id.floatingBtn_userInfo);

        //이벤트 등록
        tv_searchBar.setOnClickListener(this);
        img_profile.setOnClickListener(this);
        img_addRoom.setOnClickListener(this);
        floatingBtn_userInfo.setOnClickListener(this);

        bestMemberLayout();
        studyRoomLayout();

    }

    private void studyRoomLayout() {

        GridLayout gridLayout = findViewById(R.id.gridLayout);
        int i = 0;
        for (; i < 5; i++) {
            View view = getLayoutInflater().inflate(R.layout.listitem_main_study_room, null);
            GridLayout.Spec spec = GridLayout.spec(GridLayout.UNDEFINED, 1.0f);
            GridLayout.LayoutParams lp = new GridLayout.LayoutParams(new ViewGroup.MarginLayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT));
            lp.columnSpec = spec;
            lp.leftMargin = 10;
            lp.rightMargin = 10;
            lp.bottomMargin = 20;
            gridLayout.addView(view, lp);
        }

        //TODO host가 자신의 rID인 스터디룸


        //TODO 접속했던 방과 동일한 분야의 스터디룸 무작위 추첨

    }

    private void bestMemberLayout() {
        //베스트 멤버에 필요한 데이터 models 변수에 담아
        models = new ArrayList<>();
        models.add(new MainBestMemberModel("분야"));
        models.add(new MainBestMemberModel("나이"));


        adapter = new MainBestMemberAdapter(models, this);
        viewpager.setPadding(0, 0, 50, 0); //오른쪽에 padding을 줘서 2번째 슬라이더가 살짝 보이게 함
        viewpager.setAdapter(adapter); //어댑터 설정
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG,v.getId()+"");
        Log.d(TAG, R.id.floatingBtn_userInfo+"");
        if (v.getId() == R.id.tv_searchBar) { // 검색바
            Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.right_in, R.anim.not_move); // 화면전환 애니메이션

        } else if (v.getId() == R.id.img_profile) { // 마이페이지 아이콘
            Intent intent = new Intent(getApplicationContext(), MyPageActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.right_in, R.anim.not_move);
        } else if (v.getId() == R.id.img_addRoom) { // 스터디룸 추가 아이콘
            Intent intent2 = new Intent(getApplicationContext(), MakeStudyRoom.class);
            startActivity(intent2);
            overridePendingTransition(R.anim.right_in, R.anim.not_move);
        } else if (v.getId() == R.id.floatingBtn_userInfo) { //플로팅 버튼
            Log.d(TAG, "dfdfdfdfd");
            DialogFragment mainFloatingDialog = new MainFloatingDialog();
            mainFloatingDialog.show(getSupportFragmentManager(), "mainFloatingDialog");
        }

    }
}
