package com.example.zengwei.newbook.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.zengwei.newbook.JSONModel.Search;
import com.example.zengwei.newbook.R;
import com.example.zengwei.newbook.Recycler.SearchAdapter;
import com.example.zengwei.newbook.Util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijunjie on 2018/3/9.
 */

public class SearchActivity extends Activity implements View.OnClickListener{


    private List<Search> searchList = new ArrayList<>();

    private ImageView img_return;
    private ImageView img_book;
    private EditText edit_search;

    private RecyclerView recyclerView;
    private LinearLayoutManager mManagerLayout;
    private Intent intent;
    private String json;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);//默认软键盘不弹出
        intent=getIntent();
        json=intent.getStringExtra("JSON");
        init();

    }


    private void init() {
        img_return = (ImageView)findViewById(R.id.img_return);
        img_book = (ImageView)findViewById(R.id.img_book);
        edit_search = (EditText)findViewById(R.id.edit_search);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        img_return.setOnClickListener(this);
        img_book.setOnClickListener(this);
        edit_search.setOnClickListener(this);
        edit_search.clearFocus();

        initSearch();
        recyclerViewEventProcessing();
    }

    private void recyclerViewEventProcessing() {
        mManagerLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mManagerLayout);
        SearchAdapter adapter = new SearchAdapter(searchList);
        recyclerView.setAdapter(adapter);
    }

    private void initSearch() {
        searchList=JsonUtil.JsonSearch(json);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_return:
                break;

        }
    }
}
