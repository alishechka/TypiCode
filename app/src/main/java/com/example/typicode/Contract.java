package com.example.typicode;

import java.util.List;

public interface Contract {

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
