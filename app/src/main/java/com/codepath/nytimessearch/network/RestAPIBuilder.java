package com.codepath.nytimessearch.network;

import android.util.Log;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by gary on 08/02/16.
 */

public class RestAPIBuilder {

	public static RestAPI buildRetrofitService() {


		OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
			@Override
			public Response intercept(Chain chain) throws IOException {
				Log.d("TAG", "here");
				HttpUrl url = chain.request().url().newBuilder().addQueryParameter("api-key", RestAPI.API_KEY).build();
				Request request = chain.request().newBuilder().url(url).build();
				return chain.proceed(request);
			}
		}).build();

		Retrofit retrofit = new Retrofit.Builder()
		.baseUrl(RestAPI.API_ENDPOINT)
		// Data converter
		.addConverterFactory(GsonConverterFactory.create())
		.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
		.client(client)
		.build();

		return retrofit.create(RestAPI.class);
	}

}