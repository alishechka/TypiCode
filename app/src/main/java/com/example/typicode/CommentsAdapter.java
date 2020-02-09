package com.example.typicode;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.typicode.model.CommentModel;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.myViewHolder> {
    private List<CommentModel> models;

    public CommentsAdapter(List<CommentModel> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comments_item, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.textView.setText(models.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_comment_card);
        }
    }
}
