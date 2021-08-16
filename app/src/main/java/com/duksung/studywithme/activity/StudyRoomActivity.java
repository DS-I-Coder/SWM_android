package com.duksung.studywithme.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.duksung.studywithme.R;
import com.duksung.studywithme.adapter.ChatMessageAdapter;
import com.duksung.studywithme.common.Common;
import com.duksung.studywithme.model.ChatMessageModel;
import com.duksung.studywithme.model.ChatType;
import com.duksung.studywithme.model.ChattingRoomModel;
import com.duksung.studywithme.model.MessageData;
import com.duksung.studywithme.model.StudyRoomModel;
import com.google.gson.Gson;

import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.socket.client.IO;
import io.socket.client.Socket;

public class StudyRoomActivity extends AppCompatActivity {

    private static final String TAG = "StudyRoomActivity";

    Socket mSocket;
    private Gson gson = new Gson();
    RelativeLayout chattingLayout;
    View cameraLayout; //
    RecyclerView rc_ChatView ;
    Button btn_message_send;
    EditText et_message_input;

    private String chatname, roomnumber, roomTitle;
    private ChatMessageAdapter adapter;
    private ImageView img_chat;
    //private TextView tv_stopWatch, tv_test;
    Chronometer tv_stopWatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_room);

        img_chat = findViewById(R.id.img_chat);
        tv_stopWatch = findViewById(R.id.tv_stopWatch);
        chattingLayout = findViewById(R.id.chattingLayout);

        tv_stopWatch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener(){
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                long time = SystemClock.elapsedRealtime() - chronometer.getBase();
                int h   = (int)(time /3600000);
                int m = (int)(time - h*3600000)/60000;
                int s= (int)(time - h*3600000- m*60000)/1000 ;
                String t = (h < 10 ? "0"+h: h)+":"+(m < 10 ? "0"+m: m)+":"+ (s < 10 ? "0"+s: s);
                chronometer.setText(t);
            }
        });
        tv_stopWatch.setBase(SystemClock.elapsedRealtime());
        tv_stopWatch.setText("00:00:00");
        tv_stopWatch.start();

        img_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chattingLayout.setVisibility(View.VISIBLE);
            }
        });
        cameraLayout = findViewById(R.id.cameraLayout);
        cameraLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chattingLayout.setVisibility(View.INVISIBLE);
            }
        });
        init();

    }

    private void init() {
        Log.d("SOCKET","aaaaa");
        rc_ChatView = findViewById(R.id.rc_ChatView);
        btn_message_send = findViewById(R.id.btn_message_send);
        et_message_input = findViewById(R.id.et_message_input);

        //URL을 토대로 클라이언트 객체 return
        try {
            mSocket = IO.socket(Common.BASE_SERVER_URL);
            Log.d("SOCKET", "Connection success : " + mSocket.id());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        //EnterChattingRommActivity에서 받아온 값
        Intent intent = getIntent();
        chatname = intent.getStringExtra("chatname");
        roomnumber = intent.getStringExtra("roomnumber");

        //리사이클러뷰에 adapter와 layoutmanager 지정
        adapter = new ChatMessageAdapter(getApplicationContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rc_ChatView.setLayoutManager(layoutManager);
        rc_ChatView.setAdapter(adapter);

        //메시지 전송 버튼 누르면 sendMessage()
        btn_message_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

        //socket과 서버 연결
        mSocket.connect();

        //서버에 roomdata 보냄
        mSocket.on(Socket.EVENT_CONNECT, args -> {
            mSocket.emit("enter", gson.toJson(new ChattingRoomModel(chatname, roomnumber)));
        });

        //서버에 보낸 사람과 메세지 정보 보냄
        mSocket.on("update", args -> {
            MessageData data = gson.fromJson(args[0].toString(), MessageData.class);
            addChat(data);
        });

    }

    //메시지 받으면 리사이클러뷰에 채팅 추가(보낸 사람, 내용, 시간)
    private void addChat(MessageData data) {
        runOnUiThread(() -> {
            adapter.addItem(new ChatMessageModel(data.getFrom(), data.getContent(), toDate(data.getSendTime()), ChatType.LEFT_MESSAGE));
            rc_ChatView.scrollToPosition(adapter.getItemCount() - 1); // 리사이클러뷰에서 보여주는 리스트의 가장 마지막을 보여주도록 스크롤을 이동
        });
    }

    //전송 버튼 누르면 실행
    private void sendMessage() {
        //소켓에 이름, 방 번호, 내용 담아서 서버로 전달
        mSocket.emit("newMessage", gson.toJson(new MessageData("MESSAGE",
                chatname,
                roomnumber,
                et_message_input.getText().toString(),
                System.currentTimeMillis())));
        //로그
        Log.d("MESSAGE", new MessageData("MESSAGE",
                chatname,
                roomnumber,
                et_message_input.getText().toString(),
                System.currentTimeMillis()).toString());

        adapter.addItem(new ChatMessageModel(chatname, et_message_input.getText().toString(), toDate(System.currentTimeMillis()), ChatType.RIGHT_MESSAGE));

        rc_ChatView.scrollToPosition(adapter.getItemCount() - 1);

        //메시지 보내고 input 비움
        et_message_input.setText("");
    }

    // 메시지 보낸 시간 반환
    private String toDate(long currentMiliis) {
        return new SimpleDateFormat("hh:mm a").format(new Date(currentMiliis));
    }

    // 이전 버튼을 누를 시 방을 나가고 소켓 통신 종료
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSocket.emit("left", gson.toJson(new ChattingRoomModel(chatname, roomnumber)));
        mSocket.disconnect();
    }


    //방 삭제
    private void delete() {
        //방 이름 넘겨서 삭제
        mSocket.emit("delete", gson.toJson(new StudyRoomModel(roomTitle)));
        //소켓 disconnect
        mSocket.disconnect();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

    }
/*
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.img_chat) {
            chattingLayout.setVisibility(View.VISIBLE);
        } else {
            Log.d(TAG, "else case");
            chattingLayout.setVisibility(View.INVISIBLE);
        }
    }*/
}