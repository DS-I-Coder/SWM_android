package com.duksung.studywithme.model;

public class MainBestMemberModel {
    private String title;  // 나이인지 분야인지

    public MainBestMemberModel(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
