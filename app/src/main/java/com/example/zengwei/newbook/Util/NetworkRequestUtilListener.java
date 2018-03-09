package com.example.zengwei.newbook.Util;

import okhttp3.Response;

/**
 * 网络数据请求监听接口
 * Created by lijunjie on 2018/3/7.
 */

public interface NetworkRequestUtilListener {
    void getJsonString(String str);
    void getJsonImage(Response response);
}
