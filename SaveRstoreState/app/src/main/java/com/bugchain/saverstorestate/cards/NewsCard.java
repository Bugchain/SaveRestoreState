package com.bugchain.saverstorestate.cards;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bugchain.saverstorestate.R;
import com.bugchain.saverstorestate.model.News;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by POSEIDON on 27/10/2558.
 */
public class NewsCard extends RecyclerView.Adapter<NewsCard.ViewHolder>{

    private List<News> list;

    public NewsCard(List<News> list){
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        News news = list.get(position);
        holder.title.setText(news.getTitle());
        Glide.with(holder.image.getContext())
                .load(news.getImageUrl())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.title);
            image = (ImageView)itemView.findViewById(R.id.image);
        }
    }
}
