package com.duksung.studywithme.model;

import java.util.ArrayList;
import java.util.List;

public class ChattingRoomModel {

    private String chatname;
    private String roomnumber;

    public ChattingRoomModel(String username, String roomnumber) {
        this.chatname = username;
        this.roomnumber = roomnumber;
    }



    public String getChatname() {
        return chatname;
    }

    public void setChatname(String chatname) {
        this.chatname = chatname;
    }

    public String getRoomNumber() {
        return roomnumber;
    }

    public void setRoomNumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }


}
