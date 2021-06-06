package com.example.developerslife;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.developerslife.database.PostRepository;
import com.example.developerslife.models.Post;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class CardFragment extends Fragment {
    private static final String ARG_COUNT = "param1";
    private Integer counter;

    private PostViewModel postViewModel;
    ArrayList<Post> posts;
    Post currentPost;
    int currentNumberOfPost = 0;
    int currentNumberOfPage = 1;
    int currentNumberOfCachePost = 0;
    int currentNumberOfCachePage = 1;

    ArrayList<Post> cachePosts = new ArrayList<>();

    TextView textView;
    ImageView imageView;

    public CardFragment() {
        // Required empty public constructor
    }

    public static CardFragment newInstance(Integer counter) {
        CardFragment fragment = new CardFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COUNT, counter);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            counter = getArguments().getInt(ARG_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card, container, false);

        textView = view.findViewById(R.id.text_card_view);
        imageView = view.findViewById(R.id.image_view);
        MaterialButton nextButton = view.findViewById(R.id.next_button);
        MaterialButton previousButton = view.findViewById(R.id.previous_button);

        previousButton.setVisibility(View.GONE);

        PostRepository repository = new PostRepository(getContext());
        repository.getLatestPosts().observe(getViewLifecycleOwner(), posts -> {
            this.posts = posts;
            currentPost = this.posts.get(currentNumberOfPost);
        });
        repository.updateLatestPostsFromRemoteDB(currentNumberOfPage - 1);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(cachePosts.size() + " size");
                if (cachePosts.size() > 0) {
                    previousButton.setVisibility(View.VISIBLE);
                }
                currentNumberOfPost++;
                cachePosts.add(posts.get(currentNumberOfPost - 1));
                textView.setText(posts.get(currentNumberOfPost - 1).getDescription());
                Glide.with(getActivity().getApplicationContext()).load(posts.get(currentNumberOfPost - 1).getPreviewURL()).into(imageView);
                if (currentNumberOfPost % 5 == 0) {
                    currentNumberOfPost = 0;
                    if (currentNumberOfPage < 2584) {
                        currentNumberOfPage++;
                        repository.updateLatestPostsFromRemoteDB(currentNumberOfPage - 1);
                    }
                    else {
                        currentNumberOfPage = 0;
                    }
                }
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumberOfPost--;
                if (currentNumberOfPost <= 1) {
                    previousButton.setVisibility(View.GONE);
                }
                textView.setText(cachePosts.get(currentNumberOfPost - 1).getDescription());
                Glide.with(getActivity().getApplicationContext()).load(cachePosts.get(currentNumberOfPost - 1).getPreviewURL()).into(imageView);
                System.out.println(cachePosts.get(currentNumberOfPost - 1).getDescription());
            }
        });

        return view;
    }

    @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*TextView textViewCounter = view.findViewById(R.id.tv_counter);
        textViewCounter.setText("Fragment No " + (counter+1));*/
    }
}