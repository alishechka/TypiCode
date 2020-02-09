package com.example.typicode;

import com.example.typicode.network.RetrofitService;

import java.util.List;

public class CommentsPresenter implements Contract.Presenter, Contract.RetroListener<CommentsPresenter> {

    private Contract.View view;
    private RetrofitService retrofitService;

    public CommentsPresenter(Contract.View view) {
        this.view = view;
    }

    @Override
    public void onSuccess(List<CommentsPresenter> list) {
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
