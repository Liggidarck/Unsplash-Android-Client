package com.george.unsplash.network.api;

import static com.george.unsplash.utils.Keys.BASE_API_URL_UNSPLASH;

import com.george.unsplash.network.api.header.TokenHeader;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UnsplashTokenClient {
    private static Retrofit retrofit = null;

    public static Retrofit getUnsplashTokenClient(String token) {
        if (retrofit == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new TokenHeader(token)).build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_API_URL_UNSPLASH)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
