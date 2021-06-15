package com.duksung.studywithme.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.duksung.studywithme.R;
import com.duksung.studywithme.adapter.SearchAdapter;

public class SearchActivity extends AppCompatActivity {
    RecyclerView rc_categoryList;
    SearchAdapter searchAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rc_categoryList = findViewById(R.id.rc_categoryList);
        rc_categoryList.setAdapter(searchAdapter);

    }
}