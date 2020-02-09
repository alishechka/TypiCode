package com.example.typicode;

import com.example.typicode.model.PostModel;
import com.example.typicode.network.RetrofitService;

import java.util.List;

public class PostsPresenter implements Contract.Presenter, Contract.RetroListener<PostModel> {

    private Contract.View view;
    private RetrofitService retrofitService;

    public PostsPresenter(Contract.View view) {
        this.view = view;
    }

    @Override
    public void onSuccess(List<PostModel> list) {
        view.showRepo(list);
    }

    @Override
    public void onFailure(Throwable t) {
        view.onError(t);
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


}
