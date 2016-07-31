package com.codepath.nytimessearch.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.codepath.nytimessearch.R;
import com.codepath.nytimessearch.models.Doc;

import java.util.List;

/**
 * Created by qiming on 7/29/2016.
 */
public class ArticleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Doc> mDoc;
    private final int VIEW_TYPE_SIMPLE = 1;
    private View.OnClickListener mOnClickListener;

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public ArticleAdapter(List<Doc> mDoc) {
        this.mDoc = mDoc;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        RecyclerView.ViewHolder articleViewHolder;
        View articleView = null;
        if (viewType == VIEW_TYPE_SIMPLE) {
            articleView = inflater.inflate(R.layout.item_article_simple, parent, false);

            articleViewHolder = new ArticleViewHolderSimple(articleView);
        }else {
            articleView = inflater.inflate(R.layout.item_article_result, parent, false);
//            ViewDataBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_article_result,
//                    parent, false);

//            articleViewHolder = new ArticleViewHolder(articleView, binding);
            articleViewHolder = new ArticleViewHolder(articleView);
        }
        articleView.setOnClickListener(view -> mOnClickListener.onClick(view));
        return articleViewHolder;
    }

    /**
     * Return the view type of the item at <code>position</code> for the purposes
     * of view recycling.
     * <p>
     * <p>The default implementation of this method returns 0, making the assumption of
     * a single view type for the adapter. Unlike ListView adapters, types need not
     * be contiguous. Consider using id resources to uniquely identify item view types.
     *
     * @param position position to query
     * @return integer value identifying the type of the view needed to represent the item at
     * <code>position</code>. Type codes need not be contiguous.
     */
    @Override
    public int getItemViewType(int position) {
        Doc doc = mDoc.get(position);
        if (doc.getMultimedia().size() == 0)
            return VIEW_TYPE_SIMPLE;
        return 0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Doc doc = mDoc.get(position);
        if (doc.getMultimedia().size() == 0) {
            // Simple
            ArticleViewHolderSimple vh = (ArticleViewHolderSimple) holder;
//            vh.tvTitle.setText(doc.getweb_url());
            String formattedText = String.format("<b><a href=''>%s</a></b>", doc.getHeadline().getMain());
            vh.tvTitle.setText(Html.fromHtml(formattedText));
        } else {
            ArticleViewHolder vh = (ArticleViewHolder) holder;
//            vh.tvTitle.setText(doc.getHeadline().getMain());
            vh.mBinding.setVariable(com.codepath.nytimessearch.BR.title, doc.getHeadline().getMain());
            String imgUrl = "http://www.nytimes.com/" + doc.getMultimedia().get(0).getUrl();
//            Picasso.with(vh.itemView.getContext()).load(imgUrl).transform(new RoundedCornersTransformation(10, 10)).placeholder(R.drawable.loading).into(vh.ivImage);
            Glide.with(vh.itemView.getContext()).load(imgUrl).placeholder(R.drawable.loading).into(vh.ivImage);
        }
    }

    /**
     * Returns the total number of items in the data set hold by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return mDoc.size();
    }
}
