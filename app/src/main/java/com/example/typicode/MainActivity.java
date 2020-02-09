package com.example.typicode;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.typicode.comments.CommentsFragment;
import com.example.typicode.posts.PostsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstPageFragment();
        navigationView = findViewById(R.id.btm_nav);
        navigationView.setOnNavigationItemSelectedListener(itemSelectedListener);


    }

    private void firstPageFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fl_fragment_container, new PostsFragment()).commit();
    }

    private void getPostFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fl_fragment_container, new PostsFragment()).commit();
    }

    private void getCommentFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fl_fragment_container, new CommentsFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener itemSelectedListener =
            item -> {
                switch (item.getItemId()) {
                    case R.id.id_comment:
                        getCommentFragment();
                        break;
                    case R.id.id_post:
                        getPostFragment();
                        break;
                }
                return true;
            };
}
