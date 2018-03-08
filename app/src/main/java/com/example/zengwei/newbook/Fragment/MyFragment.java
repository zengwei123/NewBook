package com.example.zengwei.newbook.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zengwei.newbook.R;

/**
 * 类创建时间为： zengwei on 2018/1/10.
 * 侧滑
 */

public class MyFragment extends android.app.Fragment {
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.cehua,null);
        return view;
    }
}
