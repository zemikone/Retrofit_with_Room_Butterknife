package com.example.zemikone.retrofit.Services;

import com.example.zemikone.retrofit.Model.Request;
import com.example.zemikone.retrofit.Model.ApiResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;



public interface API {

/// To Create JSON Object
//    @Headers({
//
//            "Accept: application/json",
//            "Content-Type: application/json;charset=UTF-8"
//
//    })

    @POST("/api/search")
    Call<ApiResponse> getRecipes(@Query("key") String key, @Query("q") String q);


    //Other methods

//    @POST("/api/search")
//    Call<ApiResponse> getRecipes(@Body Request request );

//    @GET("/api/unknown")
//    Call<MultipleResource> doGetListResources();
//
//    @POST("/api/users")
//    Call<User> createUser(@Body User user);
//
//    @GET("/api/users?")
//    Call<UserList> doGetUserList(@Query("page") String page);
//
//    @FormUrlEncoded
//    @POST("/api/users?")
//    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);

}
