package com.duksung.studywithme.model;

public class MessageData {

    private String type; //보낸 메세지인지 받은 메세지인지
    private String from; //  메세지 보낸 사람 이름 
    private String to; //메세지 보낼 방
    private String content; // 메세지 내용
    private long sendTime; //메세지 보낸 시간

    public MessageData(String type, String from, String to, String content, long sendTime) {
        this.type = type;
        this.from = from;
        this.to = to;
        this.content = content;
        this.sendTime = sendTime;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getSendTime() {
        return sendTime;
    }

    public void setSendTime(long sendTime) {
        this.sendTime = sendTime;
    }



}
