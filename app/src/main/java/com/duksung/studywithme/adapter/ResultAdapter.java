package com.duksung.studywithme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.duksung.studywithme.R;
import com.duksung.studywithme.model.SearchResultModel;

import java.util.ArrayList;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ViewHolder> {
    private static final String TAG = "ResultAdapter";
    private ArrayList<SearchResultModel> mList;
    private Context context;

    /* 생성자 */
    public ResultAdapter(ArrayList<SearchResultModel> mList, Context context) {
        this.context = context;
        this.mList = mList;
    }

    /* onCreateViewHolder - ViewHolder 객체 생성 */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_study_room, parent, false);
        return new ResultAdapter.ViewHolder(root);
    }

    /* onBindViewHolder - 생성된 뷰홀더에 데이터 바인딩 */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String roomTitle = mList.get(position).getRoomTitle();
        int maxParticipant = mList.get(position).getMaxParticipant();
        int curParticipant = mList.get(position).getCurParticipant();

        holder.tv_result_item.setText(roomTitle);
        holder.tv_number_of_participant.setText(curParticipant+"/"+maxParticipant); // "참여인원/최대인원" 형태로 보여줌.
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    /*--------------------------------------------------------------------
       ViewHolder 클래스
     *--------------------------------------------------------------------*/
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_result_item;
        TextView tv_number_of_participant;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_result_item = itemView.findViewById(R.id.tv_result_item);
            tv_number_of_participant = itemView.findViewById(R.id.tv_number_of_participant);

            /* 리스트 항목 이벤트 처리*/
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition(); // 누른 리스트 항목의 위치값을 반환.

                    if (pos != RecyclerView.NO_POSITION){ // 간혹 위치값을 -1로 반환할 때가 있어 확인.
                        Toast.makeText(context, mList.get(pos).getRoomTitle(), Toast.LENGTH_LONG);
                    }
                }
            });
        }
    }
}
