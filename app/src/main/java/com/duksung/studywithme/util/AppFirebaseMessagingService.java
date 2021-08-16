package com.duksung.studywithme.util;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class AppFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onNewToken(@NonNull String s) { // 새 토큰이 생성될 때마다 콜백 호출
        super.onNewToken(s);

        // 토큰이 확보되었으면 앱 서버로 전송하고 원하는 방법으로 저장할 수 있음.
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
    }

    

}
