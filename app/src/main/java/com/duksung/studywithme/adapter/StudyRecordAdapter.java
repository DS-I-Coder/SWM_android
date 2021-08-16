package com.duksung.studywithme.adapter;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.duksung.studywithme.R;
import com.duksung.studywithme.model.StudyRecordModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class StudyRecordAdapter extends RecyclerView.Adapter<StudyRecordAdapter.ViewHolder> {

    private ArrayList<StudyRecordModel> studyRecordModels;

    @NonNull
    @NotNull
    @Override
    public StudyRecordAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mypage_studyrecord, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull StudyRecordAdapter.ViewHolder holder, int position) {
        holder.onBind(studyRecordModels.get(position));
    }

    public void setRecordList(ArrayList<StudyRecordModel> list){
        this.studyRecordModels=list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return studyRecordModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_record_title;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            tv_record_title=itemView.findViewById(R.id.tv_record_title);

        }

        void onBind(StudyRecordModel item){
            tv_record_title.setText(item.getTitle());
        }


    }
}
