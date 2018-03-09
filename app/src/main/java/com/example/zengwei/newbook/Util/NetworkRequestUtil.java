package com.example.zengwei.newbook.Util;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 网络请求
 * Created by lijunjie on 2018/3/7.
 */

public class NetworkRequestUtil {
    private static Request request;
    private static OkHttpClient client;
    private static Response response;

    /**
     *
     * @param url   链接
     * @param networkRequestUtilListener  事件
     * @throws IOException
     */
    public static void sendRequestWithOkHttp(final String url, final NetworkRequestUtilListener networkRequestUtilListener) throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    client=new OkHttpClient();
                    request = new Request.Builder().url(url).build();
                    response=client.newCall(request).execute();
                    networkRequestUtilListener.getJsonString(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    /**
     *
     */
    public static void sendRequestImage(final String url, final NetworkRequestUtilListener networkRequestUtilListener){
        String URL=UrlDecode.getURLDecoderString(url);
        client = new OkHttpClient();
       request = new Request.Builder().get().url(URL.substring(7,URL.length())).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                networkRequestUtilListener.getJsonImage(response);
            }
        });
    }
}
