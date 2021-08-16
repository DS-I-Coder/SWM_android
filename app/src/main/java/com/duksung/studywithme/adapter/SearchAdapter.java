package com.duksung.studywithme.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.duksung.studywithme.R;
import com.duksung.studywithme.activity.ResultActivity;
import com.duksung.studywithme.model.CategoryModel;
import com.duksung.studywithme.retrofit.RetrofitService;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private String[] strings;
    private Context context;

    /* 생성자 */
    public SearchAdapter(String[] strings, Context context) {
        this.strings = strings;
        this.context = context;
    }

    /* onCreateViewHolder - ViewHolder 객체 생성 */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_search_category, parent, false);

        return new SearchAdapter.ViewHolder(root);
    }

    /* onBindViewHolder - 생성된 뷰홀더에 데이터 바인딩 */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        String str = strings[position];
        holder.category.setText("# "+str); // '# 카테고리명' 형식으로 설정
    }

    /* getItemCount */
    @Override
    public int getItemCount() {
        return strings.length;
    }

    /*--------------------------------------------------------------------
       ViewHolder 클래스 => 리스트 항목에 컴포넌트 참조 및 이벤트 처리
     *--------------------------------------------------------------------*/
     class ViewHolder extends RecyclerView.ViewHolder{

        TextView category;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.tv_category_item);

            /* 카테고리 클릭시 이벤트 처리 */
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();

                    /** 지원: 수정 필요
                     * 1) 카테고리 명이 포함된 제목 검색?
                     * 2) 방마다 해시태그가 있어, 그걸로 검색 - 방마다 소유하고 있는 카테고리 id 대조해서 찾기
                     */

                    //인텐트
                    Intent intent = new Intent(context, ResultActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }

}
