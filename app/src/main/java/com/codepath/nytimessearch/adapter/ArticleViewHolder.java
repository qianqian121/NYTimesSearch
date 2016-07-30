package com.codepath.nytimessearch.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.nytimessearch.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by qiming on 7/29/2016.
 */
public class ArticleViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.ivImage)
    ImageView ivImage;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
//    R.layout.item_article_result

    public ArticleViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
