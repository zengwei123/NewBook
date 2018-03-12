package com.example.zengwei.newbook.Recycler;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zengwei.newbook.JSONModel.Search;
import com.example.zengwei.newbook.R;
import com.example.zengwei.newbook.Util.UrlDecode;

import java.util.List;

/**
 * Created by lijunjie on 2018/3/9.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private List<Search> searches;

    public SearchAdapter(List<Search> resultsBeans){
        searches = resultsBeans;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String covers=UrlDecode.getURLDecoderString(searches.get(position).getCover());
        Glide.with(holder.cover.getContext())
                .load(covers.substring(7,covers.length())).into(holder.cover);
        Search search = searches.get(position);
        holder.title.setText(search.getTitle());
        holder.author.setText(search.getAuthor());
        holder.cat.setText(search.getCat());

    }


    @Override
    public int getItemCount() {
        return searches.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        /**
         * cover :书籍封面
         * title :书名
         * author :作者
         * cat :书籍类别
         */

        ImageView cover;
        TextView title;
        TextView author;
        TextView cat;

        public ViewHolder(View view) {
            super(view);
            cover = (ImageView)view.findViewById(R.id.cover);
            title = (TextView) view.findViewById(R.id.title);
            author = (TextView)view.findViewById(R.id.author);
            cat = (TextView)view.findViewById(R.id.cat);


        }
    }
}
