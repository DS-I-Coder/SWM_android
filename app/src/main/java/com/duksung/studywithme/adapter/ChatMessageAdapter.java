package com.duksung.studywithme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.duksung.studywithme.R;
import com.duksung.studywithme.model.ChatMessageModel;
import com.duksung.studywithme.model.ChatType;

import java.util.ArrayList;

public class ChatMessageAdapter extends RecyclerView.Adapter {

    private ArrayList<ChatMessageModel> items = new ArrayList<ChatMessageModel>();
    private Context context;

    public ChatMessageAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {

        //보낸 메시지 화면과 메시지 받은 화면 재사용
        //받을 때 말풍선, 보낼 때 말풍선 따로 만들어 둔 거 사용

        View view;
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if (viewType == ChatType.LEFT_MESSAGE) { //받은 메시지
            view = inflater.inflate(R.layout.fragment_message_received, parent, false);
            return new LeftViewHolder(view);
        } else { //보낸 메시지
            view = inflater.inflate(R.layout.fragment_message_sent, parent, false);
            return new RightViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull RecyclerView.ViewHolder viewHolder, int position) {
        //뷰 홀더 안에 표시할 데이터와 연결
        
        if (viewHolder instanceof LeftViewHolder) { //받은 메시지
            ChatMessageModel item = items.get(position);
            ((LeftViewHolder) viewHolder).setItem(item);
        } else {// 보낸 메시지
            ChatMessageModel item = items.get(position);
            ((RightViewHolder) viewHolder).setItem(item);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(ChatMessageModel item) {
        items.add(item);
        notifyDataSetChanged();
    }


    @Override
    public int getItemViewType(int position) { 
        return items.get(position).getViewType();
    }
 
    public class LeftViewHolder extends RecyclerView.ViewHolder { //받은 메시지
        TextView nameText;
        TextView contentText;
        TextView sendTimeText;

        public LeftViewHolder(View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.tv_name_received);
            contentText = itemView.findViewById(R.id.tv_message_received);
            sendTimeText = itemView.findViewById(R.id.tv_time_received);
        }

        public void setItem(ChatMessageModel item) {
            nameText.setText(item.getName());
            contentText.setText(item.getContent());
            sendTimeText.setText(item.getSendTime());
        }
    }

    public class RightViewHolder extends RecyclerView.ViewHolder { //보낸 메시지
        TextView contentText;
        TextView sendTimeText;

        public RightViewHolder(View itemView) {
            super(itemView);

            contentText = itemView.findViewById(R.id.tv_message_sent);
            sendTimeText = itemView.findViewById(R.id.tv_time_sent);
        }

        public void setItem(ChatMessageModel item) {
            contentText.setText(item.getContent());
            sendTimeText.setText(item.getSendTime());
        }
    }


}
