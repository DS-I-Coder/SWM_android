package com.duksung.studywithme.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.duksung.studywithme.R;
import com.duksung.studywithme.adapter.ResultAdapter;
import com.duksung.studywithme.model.SearchResultModel;
import com.duksung.studywithme.model.TestModel;
import com.duksung.studywithme.retrofit.RetrofitService;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;

/**
 * 검색결과.
 */
public class ResultActivity extends AppCompatActivity {
    private static final String TAG = "ResultActivity";
    EditText et_searchBar;
    RecyclerView rc_resultList;
    ResultAdapter adapter;

    RetrofitService retrofitService;

    private ArrayList<SearchResultModel> searchResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        et_searchBar = findViewById(R.id.et_searchBar);
        rc_resultList = findViewById(R.id.rc_resultList);

        // intent로 넘어온 검색 결과 데이터 받기
        Intent intent = getIntent();
        //putExtra("searchResult", X) 로 넣어준 값 받기.
        searchResult = (ArrayList<SearchResultModel>) intent.getSerializableExtra("searchResult");

        //결과 리스트 adapter 설정
        adapter = new ResultAdapter(searchResult, this);
        rc_resultList.setAdapter(adapter);

    }
}