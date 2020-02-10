package com.example.typicode.comments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.typicode.Contract;
import com.example.typicode.R;
import com.example.typicode.model.CommentModel;

import java.util.List;

public class CommentsFragment extends Fragment implements Contract.View<CommentModel> {
    private RecyclerView recyclerView;
    private CommentsAdapter adapter;
    private Contract.Presenter presenter;
    private TextView errorMessage;
    private ProgressBar progressBar;
    private ConstraintLayout recyclerLayout;
    private LinearLayout errorLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_comment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_display_comment);
        errorMessage = view.findViewById(R.id.tv_error_message_comments);
        progressBar = view.findViewById(R.id.pb_loading_comment);
        recyclerLayout = view.findViewById(R.id.comment_layout);
        errorLayout = view.findViewById(R.id.error_container_comments);

        presenter = new CommentsPresenter(this);
        presenter.getRepo();
    }

    @Override
    public void showRepo(List<CommentModel> list) {
        adapter = new CommentsAdapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerLayout.setVisibility(View.VISIBLE);

    }


    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void showError(Throwable t) {
        Toast.makeText(getContext(), getString(R.string.connection_error_message), Toast.LENGTH_SHORT).show();
        errorMessage.setText(t.getMessage());
        errorLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideError() {
        errorLayout.setVisibility(View.GONE);

    }

    @Override
    public void onDestroy() {
        presenter.onDestroyCalled();
        super.onDestroy();
    }
}
