package com.example.ppp.dagger2training.network;

import com.example.ppp.dagger2training.models.User;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by ppp on 2016/01/23.
 */
public interface GithubApi {
    @GET("/users/{name}")
    Observable<Response<User>> getUser(@Path("name") String name);

    @GET("/users/{name}")
    Call<User> getUserAsync(@Path("name") String name);
}
