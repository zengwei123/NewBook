package com.example.zengwei.newbook.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 类创建时间为： zengwei on 2018/1/16.
 */

public class TestHttp {
    public String httpget(String url){
        String str="";
        try {
            URL urls=new URL(url);
            HttpURLConnection httpURLConnection= (HttpURLConnection) urls.openConnection();
            if (httpURLConnection.getResponseCode()==200){
                InputStreamReader inputStreamReader=new InputStreamReader(httpURLConnection.getInputStream());
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                String str1="";
                if((str1=bufferedReader.readLine())!=null){
                    str+=str1;
                }
                bufferedReader.close();
                inputStreamReader.close();
                httpURLConnection.disconnect();
                return str;
            }else{
                return "null";
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "null";
        } catch (IOException e) {
            e.printStackTrace();
            return "null";
        }

    }
    public String abc(final String url) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask=new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return httpget(url);
            }
        });
        return futureTask.get();
    }
}
