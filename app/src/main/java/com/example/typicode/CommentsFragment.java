package com.example.typicode;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.typicode.model.CommentModel;

import java.util.List;

public class CommentsFragment extends Fragment implements Contract.View<CommentModel> {
    private RecyclerView recyclerView;
    private CommentsAdapter adapter;
    private Contract.Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_comment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_display_comment);
        presenter = new CommentsPresenter(this);
        presenter.getRepo();
    }

    @Override
    public void showRepo(List<CommentModel> list) {
        adapter = new CommentsAdapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onError(Throwable t) {
        Toast.makeText(getContext(), "no connection", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        presenter.onDestroyCalled();
        super.onDestroy();
    }
}
