package com.example.typicode.posts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.typicode.R;
import com.example.typicode.model.PostModel;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.myViewHolder> {
    private List<PostModel> models;

    public PostAdapter(List<PostModel> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.posts_item, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.title.setText(models.get(position).getTitle());
        holder.bodyText.setText(models.get(position).getBody());


    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView bodyText;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_post_title);
            bodyText = itemView.findViewById(R.id.tv_post_body);
        }
    }
}
