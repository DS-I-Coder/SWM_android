package com.duksung.studywithme.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SearchResultModel implements Serializable {
    // ArrayList<CustomObject>를 인텐트로 넘기기 위해 Serializable 인터페이스 상속
    // 나중에 서버에서 응답받은 값을 인텐트로 넘겨줄 때, putExtra/getSerializableExtra 로 주고 받을 수 있음

    // 검색어 검색 후 결과 리스트에 나타낼 데이터
    String roomTitle;        // 방이름
    int maxParticipant;             // 방 최대 인원
    int curParticipant;         // 방 참여인원

    /*
    서버에서 보내주는 변수명과 반드시 같아야 함. 그래서 애초에 동일하게 변수명을 주던가,
    서버에서 db 쿼리문 작성시 별칭을 안드로이드 변수명과 같게 하던가,
    아래처럼 SerializedName으로 매칭시켜줄 수 있다.
        @SerializedName("rTitle")
        String room_Title;
    예를들어, 서버가 값을
        {
          { rTitle : 계리사 시험공부,
            max : 5 }
          { rTitle : ㅁㅁㅁㅁㅁㅁㅁ,
            max: 2 }
        }
     뭐 대충 이런식이라면, 방 제목을 rTitle이라는 이름으로 주는데, 클라이언트에서는 roomTitle이라는
     변수명으로 써서 매칭이 안돼서 값을 못받는다. 이때, SerializedName("서버에서 주는 변수명")
     해주면 성공적으로 연결된다는 뜻.
    */
    public SearchResultModel(String roomTitle, int maxParticipant, int curParticipant) {
        this.roomTitle = roomTitle;
        this.maxParticipant = maxParticipant;
        this.curParticipant = curParticipant;
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    public int getMaxParticipant() {
        return maxParticipant;
    }

    public void setMaxParticipant(int maxParticipant) {
        this.maxParticipant = maxParticipant;
    }

    public int getCurParticipant() {
        return curParticipant;
    }

    public void setCurParticipant(int curParticipant) {
        this.curParticipant = curParticipant;
    }
}
