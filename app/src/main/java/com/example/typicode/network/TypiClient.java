package com.example.typicode.network;

import com.example.typicode.model.CommentModel;
import com.example.typicode.model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TypiClient {
    @GET("posts")
    Call<List<PostModel>> getPosts();

    @GET("posts/1/comments")
    Call<List<CommentModel>> getComments();
}
