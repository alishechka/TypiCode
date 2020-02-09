package com.example.typicode.network;

import com.example.typicode.Contract;
import com.example.typicode.model.CommentModel;
import com.example.typicode.model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitService {
    private Contract.RetroListener retroListener;

    public RetrofitService(Contract.RetroListener retroListener) {
        this.retroListener = retroListener;
    }

    public void getPostRetroCall() {
        TypiClient client = RetrofitInstance.getClient();
        Call<List<PostModel>> call = client.getPosts();
        call.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                if (response.body() != null) {
                    retroListener.onSuccess(response.body());
                } else {
                    retroListener.onFailure(new Throwable());
                }
            }
            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                retroListener.onFailure(t);
            }
        });
    }
    public void getCommentRetroCall() {
        TypiClient client = RetrofitInstance.getClient();
        Call<List<CommentModel>> call = client.getComments();
        call.enqueue(new Callback<List<CommentModel>>() {
            @Override
            public void onResponse(Call<List<CommentModel>> call, Response<List<CommentModel>> response) {
                if (response.body() != null) {
                    retroListener.onSuccess(response.body());
                } else {
                    retroListener.onFailure(new Throwable());
                }
            }
            @Override
            public void onFailure(Call<List<CommentModel>> call, Throwable t) {
                retroListener.onFailure(t);
            }
        });
    }
}
