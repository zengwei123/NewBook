package com.example.zengwei.newbook.Recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zengwei.newbook.R;

import java.util.List;

/**
 * 类创建时间为： zengwei on 2018/1/10.
 * RecyclerView 的适配器
 */

public class MyRecycler extends RecyclerView.Adapter<MyRecycler.MyViewHolder>{
    private List<String> list;
    private Context context;
    private int x=0; //用来进行滑动距离判断 滑动显示删除按钮  妈的侧滑写不出
    private int xx=0;
    private RecyclerItemListener recyclerItemListener;  //接口用来实现事件
    public MyRecycler(Context context,List<String> list,RecyclerItemListener recyclerItemListener){
        this.list=list;
        this.context=context;
        this.recyclerItemListener=recyclerItemListener;  //传入实现的事件

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycleritem,parent,false);//获取布局
        MyViewHolder myViewHolder=new MyViewHolder(view);  //打锤子
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.bookname.setText("书名："+list.get(position));
       // holder.seal.setText("章节");
        //滑动显删除按钮
        holder.itemLinear.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        x=(int)event.getX(); //获取按下的x坐标点
                        break;
                    case MotionEvent.ACTION_MOVE:
                        xx=(int)event.getX(); //获取抬起的坐标点
                        if(x-xx>200){
                            //距离大于300就显示
                            holder.butlinear.setVisibility(View.VISIBLE);
                        }
                        break;
                }
                return false;
            }
        });
        //点击隐藏删除按钮  跳转章节页面
        holder.itemLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.butlinear.getVisibility()==View.GONE) {  //判断删除按钮是否显示
                        //执行事件   这吊毛事件在mainActivity里面  跳转====
                        recyclerItemListener.IntentLokkActivity();
                }else{
                    if(xx==0){
                        //隐藏按钮
                        holder.butlinear.setVisibility(View.GONE);
                    }
                    xx=0;//反正就是要归0  因为他会跟触摸事件同时触发
                }
            }
        });
        //删除按钮事件
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("zeng",""+position);
                recyclerItemListener.DeleteAlertShow(position);
            }
        });
        holder.fatup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("zeng",""+position);
                recyclerItemListener.FatupAlertShow(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView bookname,seal;
        private Button delete,fatup;
        private LinearLayout itemLinear,butlinear;
        private ImageView img;
        public MyViewHolder(View itemView) {
            super(itemView);
            //item主布局
            itemLinear= (LinearLayout) itemView.findViewById(R.id.itemLinear);
            //书名
            bookname= (TextView) itemView.findViewById(R.id.bookname);
            //章节名
            seal= (TextView) itemView.findViewById(R.id.seal);
            //按钮布局
            butlinear=(LinearLayout) itemView.findViewById(R.id.butlinear);
            //删除按钮
            delete= (Button) itemView.findViewById(R.id.delete);
            //养肥区按钮
            fatup=(Button) itemView.findViewById(R.id.fatup);
            //图片
            img= (ImageView) itemView.findViewById(R.id.img);
        }
    }

}
