package com.example.zengwei.newbook.Util;

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


    private static List<Search> searchList;
    public static List<Search> jsonJX(String resultString) {
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
//                            Intent resultIntent = new Intent();
//                            Bundle bundle = new Bundle();
//                            bundle.putString("result", );
//                            bundle.putString("asset_name", asset_name);
//                            bundle.putString("reason_content", reason_content);
//                            resultIntent.putExtras(bundle);
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

}
