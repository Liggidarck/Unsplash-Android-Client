package com.george.unsplash.network.api;

import com.george.unsplash.network.models.topic.Topic;
import com.george.unsplash.network.models.user.Token;
import com.george.unsplash.network.models.photo.Photo;
import com.george.unsplash.network.models.user.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UnsplashInterface {

    @POST("oauth/token")
    Call<Token> getToken(@Query("client_id") String client_id,
                         @Query("client_secret") String client_secret,
                         @Query("redirect_uri") String redirect_uri,
                         @Query("code") String code,
                         @Query("grant_type") String grant_type);
    @GET("me")
    Call<User> getUsersData();

    @GET("photos/random")
    Call<Photo> getRandomPhoto(@Query("orientation") String orientation);

    @GET("topics")
    Call<List<Topic>> getTopics();

    @GET("photos")
    Call<List<Photo>> getPhotos(@Query("page") Integer page,
                                @Query("per_page") Integer perPage,
                                @Query("order_by") String orderBy);

    @GET("photos/{id}")
    Call<Photo> getPhoto(@Path("id") String id,
                         @Query("w") Integer width,
                         @Query("h") Integer height);

}