package com.example.typicode.posts;

import com.example.typicode.Contract;
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
        retrofitService.getPostRetroCall();
    }

    @Override
    public void onDestroyCalled() {
        view = null;
    }


}
