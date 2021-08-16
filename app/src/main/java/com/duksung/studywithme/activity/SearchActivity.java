package com.duksung.studywithme.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.duksung.studywithme.R;
import com.duksung.studywithme.adapter.SearchAdapter;
import com.duksung.studywithme.common.Common;
import com.duksung.studywithme.model.CategoryModel;
import com.duksung.studywithme.model.SearchResultModel;
import com.duksung.studywithme.retrofit.RetrofitHelper;
import com.duksung.studywithme.retrofit.RetrofitService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *  검색어나 카테고리로 방 찾기. 상단에 검색바, 하단에 카테고리리스트 존재.
 */
public class SearchActivity extends AppCompatActivity {
    private static final String TAG = "SearchActivity";
    RecyclerView rc_categoryList;
    SearchAdapter searchAdapter;
    EditText et_searchBar;
    //ArrayList<CategoryModel> categoryModels;
    RetrofitService retrofitService = RetrofitHelper.getRetrofit().create(RetrofitService.class);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        et_searchBar = findViewById(R.id.et_searchBar);
        rc_categoryList = findViewById(R.id.rc_categoryList);

        // * (수정) 지금은 메인페이지 검색바 눌렀을 때,
        //Intent intent = getIntent();
        //categoryModels = (ArrayList<CategoryModel>) intent.getSerializableExtra("category");

        // * category 리사이클러 뷰
        // 리사이클러 뷰에 대한 이벤트 처리는 어댑터의 몫.
        searchAdapter = new SearchAdapter(getResources().getStringArray(R.array.category), this);
        rc_categoryList.setAdapter(searchAdapter);


        // * 이벤트 처리 - 검색어 입력
        et_searchBar.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // 검색어 입력 후, 키보드에서 엔터를 치면 동작.
                if((event.getAction() == KeyEvent.ACTION_DOWN)&&(keyCode == KeyEvent.KEYCODE_ENTER)){

                    String keyword = et_searchBar.getText().toString(); // 검색어 가져오기

                    if (Common.isStringEmpty(keyword)){ // 아무것도 입력하지 않았을 경우
                        Toast.makeText(SearchActivity.this, "검색어를 입력하세요.", Toast.LENGTH_SHORT).show();
                        return false;
                    }

                    /* RETROFIT */
                    retrofitService.getSearchResult(keyword)
                            .enqueue(new Callback<ArrayList<SearchResultModel>>() {
                        @Override
                        public void onResponse(Call<ArrayList<SearchResultModel>> call, Response<ArrayList<SearchResultModel>> response) {
                            ArrayList<SearchResultModel> models = response.body(); //응답값

                            // 검색결과 intent로 ResultActivity에 넘겨중.
                            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                            intent.putExtra("searchResult", models);
                            startActivity(intent);
                            //화면전환애니메이션(overridePending어쩌구)은 startActivity 다음에 써주면 됨.
                            //지금은 아직 안쓴 것.
                        }

                        @Override
                        public void onFailure(Call<ArrayList<SearchResultModel>> call, Throwable t) {
                            Log.d(TAG, t.getMessage()); // 오류메세지 로그 출력
                        }
                    });

                    return true;
                }
                return false;
            }
        });
    }

}