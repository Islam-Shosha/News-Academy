package com.example.apiapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apiapi.models.Article;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewHolder> {

    List<Article>articleList;

    public NewsAdapter(List<Article> articleList) {
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public NewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewHolder holder, int position) {
    Article article = articleList.get(position);
    holder.textViewTitle.setText(article.getTitle());
        Glide.with(holder.itemView)
                .load(article.getUrl())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    class NewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textViewTitle;
        public NewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_news);
            textViewTitle=itemView.findViewById(R.id.tv_title);
        }
    }
}
