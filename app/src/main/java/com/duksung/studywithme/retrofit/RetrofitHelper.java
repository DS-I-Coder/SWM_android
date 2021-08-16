package com.duksung.studywithme.retrofit;

import com.duksung.studywithme.common.Common;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Common.BASE_SERVER_URL)
                    //.baseUrl("http://192.168.214.1:8000") // ip주소 뒤에는 포트번호
//                  .baseUrl("http://192.168.0.3:8000") // ip주소 뒤에는 포트번호
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
