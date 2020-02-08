package com.example.typicode.network;

import com.example.typicode.Constract;
import com.example.typicode.model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitService {
    private Constract.RetroListener retroListiner;

    public RetrofitService(Constract.RetroListener retroListener) {
        this.retroListiner = retroListener;
    }

    public void getRetroCall() {
        TypiClient client = RetrofitInstance.getClient();
        Call<List<PostModel>> call = client.getPosts();
        call.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                if (response.body() != null) {
                    retroListiner.onSuccess(response.body());
                } else {
                    retroListiner.onFailure(new Throwable());
                }
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                retroListiner.onFailure(t);
            }
        });
    }
}