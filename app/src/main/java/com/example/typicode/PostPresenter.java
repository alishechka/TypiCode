package com.example.typicode;

import com.example.typicode.model.PostModel;
import com.example.typicode.network.RetrofitService;

import java.util.List;

public class PostPresenter implements Constract.Presenter, Constract.RetroListener <PostModel>{

    private Constract.View view;
    private RetrofitService retrofitService;

    public PostPresenter(Constract.View view) {
        this.view = view;
    }

    @Override
    public void getRepo() {
        retrofitService = new RetrofitService(this);
        retrofitService.getRetroCall();
    }

    @Override
    public void onDestroyCalled() {
        view = null;
    }

    @Override
    public void onSuccess(List<PostModel> list) {
        view.showRepo(list);
    }

    @Override
    public void onFailure(Throwable t) {
        view.onError(t);
    }
}
