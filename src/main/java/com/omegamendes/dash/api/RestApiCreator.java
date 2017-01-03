package com.omegamendes.dash.api;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by omegamendes on 7/17/16.
 */
public class RestApiCreator {
    
    public static Dota2RestApi dota2API() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        
        builder.addInterceptor(chain -> {
            Request original = chain.request();
            HttpUrl originalHttpUrl = original.url();
    
            HttpUrl url = originalHttpUrl.newBuilder()
                    .addQueryParameter("key", "E887EA32AD3B685AEEFDA3D773CC3112")
                    .addQueryParameter("matches_requested", "50")
                    .build();
    
            // Request customization: add request headers
            Request.Builder requestBuilder = original.newBuilder()
                    .url(url);
    
            Request request = requestBuilder.build();
            return chain.proceed(request);
        });
        
        OkHttpClient client = builder.build();
        
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Dota2RestApi.URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(Dota2RestApi.class);
    }
}
