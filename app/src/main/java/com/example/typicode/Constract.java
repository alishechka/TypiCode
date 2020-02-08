package com.example.typicode;

import com.example.typicode.model.PostModel;

import java.util.List;

public interface Constract {

    interface View<T> {
        void showRepo(List<T> list);

        void onError(Throwable t);

    }

    interface Presenter {
        void getRepo();

        void onDestroyCalled();
    }

    interface RetroListener<T> {
        void onSuccess(List<T> list);

        void onFailure(Throwable t);
    }
}
