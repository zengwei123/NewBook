package com.example.zengwei.newbook.Util;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;

/**
 * 类创建时间为： zengwei on 2018/1/11.
 */

public class MyAlert  {
    //将弹出对话框的设置在这里面进行
    public AlertDialog.Builder setMyAlert(AlertDialog.Builder builder, String title, String Message, final MyAlertListener mal){
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("zeng","取消");
            }
        });
        builder.setNeutralButton("确定",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("zeng","确定");
                mal.onButtonClick();
            }
        });
        return builder;
        /**
         * dsaasdsadasdasadsa
         */
    }
}
