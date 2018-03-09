package com.example.zengwei.newbook.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.zengwei.newbook.JSONModel.Search;
import com.example.zengwei.newbook.MainActivity;
import com.example.zengwei.newbook.R;
import com.example.zengwei.newbook.Recycler.SearchAdapter;

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
    private String bookname;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        intent=getIntent();
        init();

    }


    private void init() {
        img_return = (ImageView)findViewById(R.id.img_return);
        img_book = (ImageView)findViewById(R.id.img_book);
        edit_search = (EditText)findViewById(R.id.edit_search);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerViewEventProcessing();
        img_return.setOnClickListener(this);
        img_book.setOnClickListener(this);
        edit_search.setOnClickListener(this);
        edit_search.clearFocus();

        initSearch();
    }

    private void recyclerViewEventProcessing() {
        mManagerLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mManagerLayout);
        SearchAdapter adapter = new SearchAdapter(searchList);
        recyclerView.setAdapter(adapter);
    }

    private void initSearch() {
        for (int i = 0; i<10; i++){
            Search search = new Search("","遮天","仙侠","辰东","","");
            searchList.add(search);

        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_return:
                break;

        }
    }
}
