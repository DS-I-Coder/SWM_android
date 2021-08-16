package com.duksung.studywithme.model;

public class StudyRoomModel {

    //방 생성시 서버에 전달하는 값(모델)
    private int rId;
    private String roomTitle;

    public StudyRoomModel(int rId){
        this.rId=rId;
    }


    public StudyRoomModel(String roomTitle){
        this.roomTitle=roomTitle;
    }


    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }




}
