package com.example.developerslife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.developerslife.database.PostRepository;
import com.example.developerslife.models.Post;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager;

    private PostViewModel postViewModel;
    ArrayList<Post> posts;
    Post currentPost;
    int currentNumberOfPost = 0;
    int currentNumberOfPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViewPager();

        /*postViewModel = new ViewModelProvider(this).get(PostViewModel.class);

        Observer<ArrayList<Post>> observer = posts -> {
            if (posts != null && posts.size() != 0) {
                this.posts = posts;
                currentPost = posts.get(currentNumberOfPost);
            }
        };

        postViewModel.updateLatestPosts(currentNumberOfPage);
        postViewModel.getLatestPosts().observe(this, observer);*/
    }

    private void setViewPager() {
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tabs);
        viewPager.setAdapter(createCardAdapter());
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    String text = null;
                    switch (position) {
                        case 0:
                            text = "Последние";
                            break;
                        case 1:
                            text = "Лучшие";
                            break;
                        case 2:
                            text = "Горячие";
                            break;
                    }
                    tab.setText(text);
                }).attach();
    }

    private ViewPagerAdapter createCardAdapter() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        return adapter;
    }
}