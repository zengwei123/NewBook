package com.example.zengwei.newbook.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zengwei.newbook.JSONModel.Detail;
import com.example.zengwei.newbook.R;
import com.example.zengwei.newbook.Util.JsonUtil;
import com.example.zengwei.newbook.Util.NetworkRequestUtil;
import com.example.zengwei.newbook.Util.NetworkRequestUtilListener;
import com.example.zengwei.newbook.Util.UrlDecode;

import java.io.IOException;
import java.net.URL;

import okhttp3.Response;


/**
 * Created by zengwei on 2018/3/6.
 */

public class DetailaBookActivity extends AppCompatActivity implements View.OnClickListener{
    private String _id;
    private TextView title;  //书名
    private TextView longIntro;   //简介
    private TextView author;   //作者
    private TextView majorCate;  //书籍类型
    private TextView minorCate;  //书籍副类型
    private TextView updated;    //更新时间
    private TextView lastChapter;   //最新章节
    private TextView wordCount;  //字数
    private TextView score;  //评分
    private TextView retentionRatio;//读者留存
    private TextView serializeWordCount;  //日跟新字数
    private ImageView cover;   //封面图片
    private Button Trial_reading;

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailbook_activity);
        getControl();
        init();
    }

    /**
     * 获取控件
     */
    private void getControl(){
        title= (TextView) findViewById(R.id.title);
        longIntro= (TextView) findViewById(R.id.longIntro);
        author= (TextView) findViewById(R.id.author);
        majorCate= (TextView) findViewById(R.id.majorCate);
        minorCate= (TextView) findViewById(R.id.minorCate);
        updated= (TextView) findViewById(R.id.updated);
        lastChapter= (TextView) findViewById(R.id.lastChapter);
        wordCount= (TextView) findViewById(R.id.wordCount);
        score= (TextView) findViewById(R.id.score);
        retentionRatio= (TextView) findViewById(R.id.retentionRatio);
        serializeWordCount= (TextView) findViewById(R.id.serializeWordCount);
        cover= (ImageView) findViewById(R.id.cover);
        Trial_reading= (Button) findViewById(R.id.Trial_reading);
    }

    /**
     * 蛇皮怪
     */
    private void init(){
        intent=getIntent();
        _id=intent.getStringExtra("_id");

        try {
            NetworkRequestUtil.sendRequestWithOkHttp("http://novel.juhe.im/book-info/5086612fd7a545903b000021", new NetworkRequestUtilListener() {
                @Override
                public void getJsonString(String str) {
                    Message msg=Message.obtain();
                    Bundle bundle = new Bundle();
                    msg.what=886;
                    bundle.putSerializable("Detail",JsonUtil.Jsondetail(str));
                    msg.setData(bundle);
                    handler.sendMessage(msg);
                }
                @Override
                public void getJsonImage(Response response) {
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置控件
     * @param detail
     */
    private void setControl(Detail detail){
        _id=detail.get_id();
        title.setText(detail.getTitle());
        longIntro.setText("        "+detail.getLongIntro());
        author.setText(detail.getAuthor());
        majorCate.setText(detail.getMajorCate());
        minorCate.setText(detail.getMinorCate());
        //时间格式整理
        String date[]=detail.getUpdated().split("T");
        updated.setText(date[0]+" "+date[1].substring(0,8));

        lastChapter.setText(detail.getLastChapter());
        score.setText("评分："+detail.getScore());
        retentionRatio.setText("读者留存："+detail.getRetentionRatio()+"%");
        //判断是否完结
        if(detail.isSerial()){
            serializeWordCount.setText("日更字数："+detail.getSerializeWordCount());
        }else{
            serializeWordCount.setText("日更字数：完结");
        }
        //书籍字数总结
        String i=detail.getWordCount()+"";
        switch (i.length()){
            case 8: wordCount.setText("字数："+i.substring(0,4)+"万");break;
            case 7: wordCount.setText("字数："+i.substring(0,3)+"万");break;
            case 6: wordCount.setText("字数："+i.substring(0,2)+"万");break;
            case 5: wordCount.setText("字数："+i.substring(0,1)+"万");break;
            case 4: wordCount.setText("字数："+detail.getWordCount());break;
        }
        //书籍分面图片
        NetworkRequestUtil.sendRequestImage( detail.getCover(), new NetworkRequestUtilListener() {
            @Override
            public void getJsonString(String str) {}
            @Override
            public void getJsonImage(Response response) {
                try {
                    Message message = handler.obtainMessage();
                    if (response.isSuccessful()) {
                        message.what = 668;
                        message.obj = response.body().bytes();
                        handler.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 子线程更新ui
     */
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==886){
                setControl((Detail) msg.getData().getSerializable("Detail"));
            }else if(msg.what==668){
                byte[] bytes = (byte[]) msg.obj;
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                cover.setImageBitmap(bitmap);
            }
        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Trial_reading:
                Intent intent=new Intent(DetailaBookActivity.this,ReadBookActivity.class);
                intent.putExtra("_id",_id);
                startActivity(intent);
                break;
        }
    }
}
