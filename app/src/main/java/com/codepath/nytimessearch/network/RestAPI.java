package com.codepath.nytimessearch.network;

import com.codepath.nytimessearch.models.Article;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by gary on 08/02/16.
 */
//public interface RestAPI {
//	// Example url testing RXJAVA
//	String API_ENDPOINT = "http://jsonplaceholder.typicode.com";
//
//	@GET("/posts/{id}")
//	Observable<Post> getPost(@Path("id") int id);
//}

public interface RestAPI {
	String API_ENDPOINT = "https://api.nytimes.com/";
	String API_KEY = "5e40ac8fa8af40d98b6cd7608a24be3b";

	@GET("/svc/search/v2/articlesearch.json")
	Observable<Article> getPost();
}