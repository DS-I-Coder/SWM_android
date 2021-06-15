package com.duksung.studywithme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.duksung.studywithme.R;
import java.util.ArrayList;
import java.util.Arrays;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private ArrayList<String> mList
            = new ArrayList<String>(Arrays.asList("토익", "공무원", "중간고사","수능", "대학생", "직장인"
            ,"취업준비","한국사", "111", "222", "333"));

    public SearchAdapter(ArrayList<String> mList) {

        //this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_search_category, parent, false);

        return new SearchAdapter.ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String str = mList.get(position);  // 임시로 생성해놓은 카테고리 리스트
        holder.textView.setText(str);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    /* 뷰홀더 클래스 */
     class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_category_item);
        }
    }

}
