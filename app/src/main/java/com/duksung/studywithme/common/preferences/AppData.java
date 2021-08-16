package com.duksung.studywithme.common.preferences;

import android.content.Context;

public class AppData extends IPreference {

    /**
     * 비교적 적은 양의 key-value값을 저장.
     */

    private static AppData mInstance; // 싱글톤 패턴 적용하기 위해 정적변수로 선언

    public static synchronized AppData getInstance(Context context){ // 싱글톤 메서드: 앱 내 단 하나의 객체만이 존재하게 함
        if (mInstance == null){
            mInstance = new AppData(context);
        }
        return mInstance;
    }

    //
    public AppData(Context context){
        super(context);
        mContext = context;
        mSharedPreferences = mContext.getSharedPreferences("IdealPref", Context.MODE_PRIVATE);
    }

    private final String PREF_LOGIN_ID = "loginID"; // key값
    private final String PREF_ACC_TIME = "accTime"; // 누적시간


    public void setPREF_LOGIN_ID(String string){ putString(PREF_LOGIN_ID, string); }
    public String getPREF_LOGIN_ID() {
        return getString(PREF_LOGIN_ID);
    }
    public void setPREF_ACC_TIME(int i){ putInt(PREF_ACC_TIME, i); }
    public int getPREF_ACC_TIME() {
        return getInt(PREF_ACC_TIME);
    }
}
