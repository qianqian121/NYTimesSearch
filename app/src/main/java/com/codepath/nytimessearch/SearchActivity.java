package com.codepath.nytimessearch;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.codepath.nytimessearch.activities.ArticleActivity;
import com.codepath.nytimessearch.adapter.ArticleAdapter;
import com.codepath.nytimessearch.adapter.EndlessRecyclerViewScrollListener;
import com.codepath.nytimessearch.fragments.SetFilterFragment;
import com.codepath.nytimessearch.models.Article;
import com.codepath.nytimessearch.models.Doc;
import com.codepath.nytimessearch.network.NetworkRequest;
import com.codepath.nytimessearch.network.RestAPI;
import com.codepath.nytimessearch.network.RestAPIBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscription;

public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rvItems)
    RecyclerView rvItems;

//    R.layout.content_search
    List<Doc> mDocs;
    ArticleAdapter mArticleAdapter;
    StaggeredGridLayoutManager mGridLayoutManager;

    private Subscription mGetPostSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        // First param is number of columns and second param is orientation i.e Vertical or Horizontal
        mGridLayoutManager =
                new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
// Attach the layout manager to the recycler view
        rvItems.setLayoutManager(mGridLayoutManager);
        mDocs = new ArrayList<>();
        mArticleAdapter = new ArticleAdapter(mDocs);
        mArticleAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "click articles", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ArticleActivity.class);
                Doc doc = mDocs.get(rvItems.getChildAdapterPosition(view));
                intent.putExtra("webUrl", doc.getweb_url());
                startActivity(intent);
            }
        });
        rvItems.setAdapter(mArticleAdapter);
//        rvItems.addOnScrollListener(new EndlessRecyclerViewScrollListener(gridLayoutManager) {
//            @Override
//            public void onLoadMore(int page, int totalItemsCount) {
//                Toast.makeText(getApplicationContext(), "loading more articles", Toast.LENGTH_SHORT).show();
//
////                RestAPI api = RestAPIBuilder.buildRetrofitService();
////                mGetPostSubscription = NetworkRequest.performAsyncRequest(api.getPost(), (data) -> {
////                    // Update UI on the main thread
////                    loadMorePost(data);
////                }, (error) -> {
////                    // Handle error
////                    Log.d("TAG", "error");
////                });
//                fetchArticlePage(0, 10, false);
//            }
//        });
    }

    private void loadMorePost(Article doc) {
        Toast.makeText(getApplicationContext(), "more articles", Toast.LENGTH_SHORT).show();
        int curSize = mArticleAdapter.getItemCount();
        mDocs.addAll(doc.getResponse().getDocs());
        mArticleAdapter.notifyItemRangeChanged(curSize, mDocs.size() - 1);
//        mTitle.setText("Title: " + post.getTitle());
//        mBody.setText("Body: " + post.getBody());
    }

    public void onClickFilter(MenuItem item) {
        Toast.makeText(getApplicationContext(), "Set Filter", Toast.LENGTH_SHORT).show();
        FragmentManager fm = getSupportFragmentManager();
        SetFilterFragment editNameDialogFragment = new SetFilterFragment();
        editNameDialogFragment.show(fm, "activity_edit_item");
    }

    private Boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public boolean isOnline() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void getArticles() {
//        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());
        // Trailing slash is needed
//        final String BASE_URL = "http://api.myservice.com/";
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
        RestAPI api = RestAPIBuilder.buildRetrofitService();
        mGetPostSubscription = NetworkRequest.performAsyncRequest(api.getPost(), (data) -> {
            // Update UI on the main thread
            displayPost(data);
        }, (error) -> {
            // Handle error
            Log.d("TAG", "error");
        });
    }

    private void displayPost(Article doc) {
        Toast.makeText(getApplicationContext(), "display articles", Toast.LENGTH_SHORT).show();
        mDocs.addAll(doc.getResponse().getDocs());
        mArticleAdapter.notifyDataSetChanged();
//        mTitle.setText("Title: " + post.getTitle());
//        mBody.setText("Body: " + post.getBody());
    }

    public void fetchArticlePage(int offset, int pages, boolean onFirstLoad) {
//        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());
        // Trailing slash is needed
//        final String BASE_URL = "http://api.myservice.com/";
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
        for (int p = 1; p < pages; p++) {
            RestAPI api = RestAPIBuilder.buildRetrofitService();
            mGetPostSubscription = NetworkRequest.performAsyncRequest(api.getPost(), (data) -> {
                // Update UI on the main thread
                addPost(data);
            }, (error) -> {
                // Handle error
                Log.d("TAG", "error");
            });
        }
        RestAPI api = RestAPIBuilder.buildRetrofitService();
        mGetPostSubscription = NetworkRequest.performAsyncRequest(api.getPost(), (data) -> {
            // Update UI on the main thread
            addPost(data);
            if (onFirstLoad) {
//                mArticleAdapter.notifyDataSetChanged();
                rvItems.addOnScrollListener(new EndlessRecyclerViewScrollListener(mGridLayoutManager) {
                    @Override
                    public void onLoadMore(int page, int totalItemsCount) {
                        Toast.makeText(getApplicationContext(), "loading more articles", Toast.LENGTH_SHORT).show();

//                RestAPI api = RestAPIBuilder.buildRetrofitService();
//                mGetPostSubscription = NetworkRequest.performAsyncRequest(api.getPost(), (data) -> {
//                    // Update UI on the main thread
//                    loadMorePost(data);
//                }, (error) -> {
//                    // Handle error
//                    Log.d("TAG", "error");
//                });
                        fetchArticlePage(0, 10, false);
                    }
                });
                mArticleAdapter.notifyDataSetChanged();
            }
            else {
                int curSize = mArticleAdapter.getItemCount();
                mArticleAdapter.notifyItemRangeChanged(curSize, mDocs.size() - 1);
            }
        }, (error) -> {
            // Handle error
            Log.d("TAG", "error");
        });
    }

    private void addPost(Article doc) {
//        Toast.makeText(getApplicationContext(), "display articles", Toast.LENGTH_SHORT).show();
        mDocs.addAll(doc.getResponse().getDocs());
//        mArticleAdapter.notifyDataSetChanged();
//        mTitle.setText("Title: " + post.getTitle());
//        mBody.setText("Body: " + post.getBody());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem searchItem = menu.findItem(R.id.miSearch);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            /**
             * Called when the user submits the query. This could be due to a key press on the
             * keyboard or due to pressing a submit button.
             * The listener can override the standard behavior by returning true
             * to indicate that it has handled the submit request. Otherwise return false to
             * let the SearchView handle the submission by launching any associated intent.
             *
             * @param query the query text that is to be submitted
             * @return true if the query has been handled by the listener, false to let the
             * SearchView perform the default action.
             */
            @Override
            public boolean onQueryTextSubmit(String query) {
                // perform query here
                Toast.makeText(getApplicationContext(), query, Toast.LENGTH_SHORT).show();
//                getArticles();
                fetchArticlePage(0, 10, true);

                // workaround to avoid issues with some emulators and keyboard devices firing twice if a keyboard enter is used
                // see https://code.google.com/p/android/issues/detail?id=24599
                searchView.clearFocus();
                return true;
            }

            /**
             * Called when the query text is changed by the user.
             *
             * @param newText the new content of the query text field.
             * @return false if the SearchView should perform the default action of showing any
             * suggestions if available, true if the action was handled by the listener.
             */
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
