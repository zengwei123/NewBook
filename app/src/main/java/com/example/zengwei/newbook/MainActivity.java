package com.example.zengwei.newbook;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zengwei.newbook.Activity.SearchActivity;
import com.example.zengwei.newbook.JSONModel.Search;
import com.example.zengwei.newbook.MyAnimation.MyAminationSetControl;
import com.example.zengwei.newbook.MyAnimation.MyAnimListener;
import com.example.zengwei.newbook.Recycler.MyRecycler;
import com.example.zengwei.newbook.Recycler.RecyclerItemListener;
import com.example.zengwei.newbook.Util.JsonUtil;
import com.example.zengwei.newbook.Util.MyAlert;
import com.example.zengwei.newbook.Util.MyAlertListener;
import com.example.zengwei.newbook.Util.NetworkRequestUtil;
import com.example.zengwei.newbook.Util.NetworkRequestUtilListener;
import com.yalantis.phoenix.PullToRefreshView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawer;
    private LinearLayout linearLayout;
    private ImageView menu;
    private RecyclerView rvsb;
    private MyRecycler myRecycler;

    private AlertDialog.Builder builder;

    private int itemid;  //删除的数据id

    private ImageView loupe;
    private EditText loupe_edit;
    private Animation animation1;
    private Animation animation2;
    private TextView name;

    private PullToRefreshView mPullToRefreshView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getControl();
        ControlListener();
        init();

    }



    /**
     * 获取控件
     */
    private void getControl(){
        drawer= (DrawerLayout) findViewById(R.id.drawer);
        linearLayout= (LinearLayout) findViewById(R.id.Linera);
        menu= (ImageView) findViewById(R.id.menu);
        rvsb= (RecyclerView) findViewById(R.id.rvsb);
        builder=new AlertDialog.Builder(this);

        loupe= (ImageView) findViewById(R.id.loupe);
        loupe_edit= (EditText) findViewById(R.id.loupe_edit);

        //搜索图片动画特效
        animation1= AnimationUtils.loadAnimation(this, R.anim.loupe);
        //搜索栏动画特效
        animation2=AnimationUtils.loadAnimation(this, R.anim.loupe_edit);
        name= (TextView) findViewById(R.id.name);

        mPullToRefreshView = (PullToRefreshView) findViewById(R.id.pull_to_refresh);

    }

    /**
     * 单独的事件控件监听
     */
    private void ControlListener(){
        loupe_edit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    String bookname=loupe_edit.getText().toString();
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(name.getWindowToken(), 0);
                    Intent resultIntent = new Intent(MainActivity.this, SearchActivity.class);
                    resultIntent.putExtra("bookname",bookname);
                    startActivity(resultIntent);
//                    try {
//
//                        NetworkRequestUtil.sendRequestWithOkHttp("http://novel.juhe.im/search?keyword="+bookname,
//                                new NetworkRequestUtilListener() {
//                                    @Override
//                                    public void getJsonString(String str) {
//
//
////                                        List<Search> searcnList=JsonUtil.jsonJX(str);
////                                        for(Search s:searcnList){
////                                            Log.d("zeng",s.toString());
////                                        }
//                                    }
//                                });
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
                return false;
            }

        });

        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //三秒后将下拉刷新的状态变为刷新完成
                        mPullToRefreshView.setRefreshing(false);
                    }
                }, 1000);
            }
        });

        //滑动事件监听
        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //防止覆盖主布局  使主布局跟随移动
                linearLayout.setX(slideOffset * drawerView.getWidth());
            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        //侧滑打开
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示侧滑栏
                drawer.openDrawer(Gravity.LEFT);
            }
        });
        //搜索图片点击事件
        loupe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loupe.startAnimation(animation1);//启动搜索图片动画
                new MyAminationSetControl(animation1, new MyAnimListener() {
                    @Override
                    public void MyAnimListenerstart() {
                        //隐藏图片
                        loupe.setVisibility(View.GONE);
                        //显示搜索框
                        loupe_edit.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void MyAnimListenerend() {
                        name.setText("I love");
                    }
                });
                //执行搜索框动画
                loupe_edit.startAnimation(animation2);
            }
        });
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!name.getText().equals("书籍")){
                    name.setText("书籍");
                    loupe_edit.setVisibility(View.GONE);
                    loupe.setVisibility(View.VISIBLE);
                    loupe.startAnimation(animation2);
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(name.getWindowToken(), 0);

                }
            }
        });
    }
    /**
     * 一些类的初始化
     */
    private void init(){
        //测试数据
        final List<String> list=new ArrayList<String>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        //传入上下文对象  数据集合   和监听方法
        myRecycler=new MyRecycler(getApplicationContext(), list, new RecyclerItemListener() {
            //这个是点击书籍的方法  点击书籍查看小说
            @Override
            public void IntentLokkActivity() {
                Log.d("zeng","你好");
            }
            // 删除按钮的点击事件 弹出删除对话框
            @Override
            public void DeleteAlertShow(final int position) {
                new MyAlert().setMyAlert(builder, "删除书籍", "大哥别删我，自己人！", new MyAlertListener() {
                    @Override
                    public void onButtonClick() {
                        //删除数据
                        list.remove(itemid);
                        //动画删除列
                        myRecycler.notifyItemRemoved(itemid);
                        //列表从positionStart位置到itemCount数量的列表项进行数据刷新
                        myRecycler.notifyItemRangeChanged(0,list.size());
                    }
                }).show();
                itemid=position;
            }
            @Override
            public void FatupAlertShow(final int position) {
                new MyAlert().setMyAlert(builder,"养肥区","移入养肥区", new MyAlertListener() {
                    @Override
                    public void onButtonClick() {

                    }
                }).show();
                itemid=position;
            }

        });
        //妈的每次都是这个没加  搞得没数据
        rvsb.setLayoutManager(new LinearLayoutManager(this));
        //添加适配器
        rvsb.setAdapter(myRecycler);
//        animation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                loupe.setVisibility(View.GONE);
//                loupe_edit.setVisibility(View.VISIBLE);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//            }
//        });
    }


}
