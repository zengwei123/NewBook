package com.example.zengwei.newbook.Util;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lijunjie on 2018/3/7.
 */

public class NetworkRequestUtil {
    private static Request request;
    private static OkHttpClient client;
    private static Response response;
    public static void sendRequestWithOkHttp(final String url, final NetworkRequestUtilListener networkRequestUtilListener) throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                client=new OkHttpClient();
                request = new Request.Builder()
                        .url(url)
                        .build();
                    response=client.newCall(request).execute();
                    networkRequestUtilListener.getJsonString(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
