package com.duksung.studywithme.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.duksung.studywithme.R;
import com.duksung.studywithme.activity.DataChartActivity;
import com.duksung.studywithme.activity.StudyRoomActivity;
import com.duksung.studywithme.model.MainBestMemberModel;

import org.w3c.dom.Text;

import java.util.List;

/**
 * MainActivity의 "베스트 멤버" PageAdapter
 *
 */
public class MainBestMemberAdapter extends PagerAdapter {
    private static final String TAG = "MainBestMemberAdapter";
    private List<MainBestMemberModel> models;
    private LayoutInflater layoutInflater;
    private Context context;

    /* 생성자 */
    public MainBestMemberAdapter(List<MainBestMemberModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    /* isViewFromObject - 페이지뷰가 특정 키 객체와 연관되는지 여부 */
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }


    /* instantiateItem - position에 해당하는 페이지 생성 */
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater
                .inflate(R.layout.item_main_bestmember, container, false); // 뷰 전개

        TextView title;

        title = view.findViewById(R.id.tv_title);

        title.setText("[ "+models.get(position).getTitle()+" ]"); // [나이], [분야]

        //* 뷰 클릭시 이벤트 처리
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // DataChartActivity(데이터 시각화 화면)으로 이동
                Intent intent = new Intent(context, StudyRoomActivity.class);
                context.startActivity(intent);
            }
        });
        container.addView(view, 0); //컨테이너에 뷰를 붙이고
        return view; //리
    }
}
