package com.duksung.studywithme.retrofit;

import com.duksung.studywithme.common.Common;
import com.duksung.studywithme.model.CategoryModel;
import com.duksung.studywithme.model.SearchResultModel;
import com.duksung.studywithme.model.StudyRoomModel;
import com.duksung.studywithme.model.TestModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {

    @FormUrlEncoded     // post 메소드 할 땐 붙여줘야함.
    @POST("/tests/")     // Helper에 지정해준 baseurl 뒤에 붙는 주소 쓰면 됨
    Call<TestModel> getUserCheck(@Field("name") String name,
                                 @Field("age") int age,
                                 @Field("address") String address);


    @GET(Common.SearchRoomURL)
    Call<ArrayList<SearchResultModel>> getSearchResult(@Query("keyword") String keyword);

    @GET(Common.GetCategoryURL)
    Call<ArrayList<CategoryModel>> getCategory();

    //방 생성할때 방 id 넘겨서 주소 생성...?
//    @GET(Common.GetStudyRoomURL)
//    Call<ArrayList<StudyRoomModel>> getStudyRoom(@Path("rId") int rId);


}
