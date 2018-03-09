package com.example.zengwei.newbook.Util;

import com.example.zengwei.newbook.JSONModel.Detail;
import com.example.zengwei.newbook.JSONModel.Search;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijunjie on 2018/3/7.
 */

public class JsonUtil {
    /**
     * 书籍搜索解析
     */
    private static List<Search> searchList;
    public static List<Search> JsonSearch(String resultString) {
        searchList=new ArrayList<Search>();
        //判断数据是空
        if (resultString != null) {
            try {
                JSONObject jsonObject = new JSONObject(resultString);
                String resultCode = jsonObject.getString("message");
                if (resultCode.equals("ok")) {
                    //获取到json数据中的activity数组内容
                    JSONObject data = jsonObject.getJSONObject("data");
                    JSONArray resultJsonArray=data.getJSONArray("books");
                    //遍历
                    for (int i = 0; i < resultJsonArray.length(); i++) {
                        JSONObject object = resultJsonArray.getJSONObject(i);
                        try {
                            String _id = object.getString("_id");
                            String title = object.getString("title");
                            String cat = object.getString("cat");
                            String author= object.getString("author");
                            String cover = object.getString("cover");
                            String lastChapter = object.getString("lastChapter");
                            Search search=new Search(_id,title,cat,author,cover,lastChapter);
                            searchList.add(search);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return searchList;
    }


    /**
     * 书籍详情解析
     */
    private static Detail detail;
    public static Detail Jsondetail(String resultString){
        try {
            if(resultString!=null){
                JSONObject jsonObject=new JSONObject(resultString);
                if(jsonObject.getString("message").equals("ok")){
                    JSONObject jsonObject1=jsonObject.getJSONObject("data");
                    detail=new Detail(
                            jsonObject1.getString("_id"),
                            jsonObject1.getString("title"),
                            jsonObject1.getString("cover"),
                            jsonObject1.getString("longIntro"),
                            jsonObject1.getString("author"),
                            jsonObject1.getString("majorCate"),
                            jsonObject1.getString("minorCate"),
                            jsonObject1.getString("updated"),
                            jsonObject1.getString("lastChapter"),
                            jsonObject1.getInt("wordCount"),
                            jsonObject1.getJSONObject("rating").getDouble("score"),
                            jsonObject1.getDouble("retentionRatio"),
                            jsonObject1.getInt("serializeWordCount"),
                            jsonObject1.getBoolean("isSerial")
                            );
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  detail;
    }
}
