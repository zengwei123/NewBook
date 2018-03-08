package com.example.zengwei.newbook.Recycler;

/**
 * 类创建时间为： zengwei on 2018/1/11.
 */

public interface RecyclerItemListener {
    //跳转接口
    void IntentLokkActivity();
    //删除话框
    void DeleteAlertShow(int position);
    //养肥话框
    void FatupAlertShow(int position);
}
