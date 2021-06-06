package com.example.developerslife;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.developerslife.database.Logger;
import com.example.developerslife.database.PostRepository;
import com.example.developerslife.models.Post;

import java.util.ArrayList;

public class PostViewModel extends AndroidViewModel {

    private static final String LOG_TAG = "PostViewModel";
    private final Logger logger;

    private final PostRepository repository;

    private final LiveData<Post> post;
    private final LiveData<ArrayList<Post>> latestPosts;

    public PostViewModel(@NonNull Application application) {
        super(application);
        logger = new Logger(LOG_TAG, true);

        repository = new PostRepository(getApplication());
        post = repository.getCurrentPost();
        latestPosts = repository.getLatestPosts();
    }

    /*public void updateLatestPosts(String nameOfPost) {
        repository.updateLatestPostsFromRemoteDB(nameOfPost);
    }
*/
    public void updateLatestPosts(int numberOfPage) {
        repository.updateLatestPostsFromRemoteDB(numberOfPage);
    }

    public LiveData<Post> getPost() {
        return post;
    }

    public LiveData<ArrayList<Post>> getLatestPosts() {
        return latestPosts;
    }
}
