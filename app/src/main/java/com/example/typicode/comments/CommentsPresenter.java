package com.example.typicode.comments;

import com.example.typicode.Contract;
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
        view.hideError();
        view.hideProgressBar();
        view.showRepo(list);
    }

    @Override
    public void onFailure(Throwable t) {
        view.hideProgressBar();
        view.showError(t);
    }

    @Override
    public void getRepo() {
        view.showProgressBar();
        retrofitService = new RetrofitService(this);
        retrofitService.getCommentRetroCall();
    }

    @Override
    public void onDestroyCalled() {
        view = null;

    }
}
