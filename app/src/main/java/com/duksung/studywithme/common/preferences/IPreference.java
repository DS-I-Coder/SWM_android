package com.duksung.studywithme.common.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class IPreference {
    /**
     * SharedPreferences는 key-value 쌍으로 값을 관리하기 때문에 자신이 설정해놓은 key를 알아야 함.
     * 값을 넣고 찾을 때 복잡하기 때문에 단순화하기 위해 IPreference 클래스를 만들어 AppData를
     */

    Context mContext;
    protected SharedPreferences mSharedPreferences;

    protected IPreference(Context appContext){ mContext = appContext; }

    public int getInt(String key) {
        return mSharedPreferences.getInt(key, 0);
    }

    public int getInt(String key, int value) {
        return mSharedPreferences.getInt(key, value);
    }

    public float getFloat(String key) {
        return mSharedPreferences.getFloat(key, 0f);
    }

    public boolean getBoolean(String key) {
        return mSharedPreferences.getBoolean(key, false);
    }

    public String getString(String key) { return mSharedPreferences.getString(key, ""); }


    public void putInt(String key, int value){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }
    public void putString(String key, String value){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }


    public void clear(){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
