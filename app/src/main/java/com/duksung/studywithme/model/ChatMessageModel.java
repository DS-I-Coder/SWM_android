package com.duksung.studywithme.model;

public class ChatMessageModel {

    private String name; //이름
    private String content; //채팅 내용
    private String sendTime; //보낸 시간
    private int viewType; // 0일 시 왼쪽(상대가 보낸 메세지), 2일 시 오른쪽(내가 보낸 메세지)

    public ChatMessageModel(String name, String content, String sendTime, int viewType) {
        this.name = name;
        this.content = content;
        this.sendTime = sendTime;
        this.viewType = viewType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }



}
