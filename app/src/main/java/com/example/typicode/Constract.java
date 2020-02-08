package com.example.typicode;

import com.example.typicode.model.PostModel;

import java.util.List;

public interface Constract {

    interface View {
        void showRepo(List<PostModel>list);

        void onError(Throwable t);

    }

    interface Presenter {
        void getRepo();

        void onDestroyCalled();
    }

    interface RetroListener {
        void onSuccess(List<PostModel> list);

        void onFailure(Throwable t);
    }
}
