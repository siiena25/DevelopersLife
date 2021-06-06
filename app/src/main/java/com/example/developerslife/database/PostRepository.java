package com.example.developerslife.database;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.developerslife.models.Post;
import com.example.developerslife.models.Posts;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Response;

public class PostRepository {
    private static final String LOG_TAG = "PostRepository";

    private final Context context;

    private final DevelopersLifeApi mJSONApi;

    private final Logger logger;

    private final MutableLiveData<Post> currentPost = new MutableLiveData<>();
    private final MutableLiveData<ArrayList<Post>> latestPosts = new MutableLiveData<>();

    private int numberOfPage = 0;

    public PostRepository(Context context) {
        this.context = context;

        logger = new Logger(LOG_TAG, true);

        mJSONApi = NetworkService.from(context).getJSONApi();
    }

    public LiveData<Post> getCurrentPost() {
        return currentPost;
    }

    public LiveData<ArrayList<Post>> getLatestPosts() {
        return latestPosts;
    }

    /*public void updatePostFromRemoteDB(final String nameOfPill) {
        mJSONApi.getPost(nameOfPill).enqueue(new NetworkCallback<Post>(LOG_TAG) {
            @Override
            public void onNullResponse(Response<Post> response) {
                logger.errorLog("Fail with update");
            }

            @Override
            public void onSuccessResponse(Response<Post> response) {
                currentPost.postValue(response.body());
            }
        });
    }*/

    public void updateLatestPostsFromRemoteDB(int numberOfPage) {
        mJSONApi.getLatestPostsWithPage(numberOfPage).enqueue(new NetworkCallback<Posts>(LOG_TAG) {
            @Override
            public void onNullResponse(Response<Posts> response) {
                logger.errorLog("Fail with update");
            }

            @Override
            public void onSuccessResponse(Response<Posts> response) {
                logger.log("Success response");
                Gson gson = new Gson();
                Post[] arrPosts = gson.fromJson(response.body().getResult(), Post[].class);
                ArrayList<Post> posts = new ArrayList<>(Arrays.asList(arrPosts));
                latestPosts.postValue(posts);
            }
        });
    }

    public boolean nextPage() {
        if (numberOfPage < 2584) {
            numberOfPage++;
            return true;
        }
        return false;
    }
}

/*
NetworkService.getInstance()
                .getJSONApi()
                .getLatestPosts()
                .enqueue(new Callback<Posts>() {
                    @Override
                    public void onResponse(@NonNull Call<Posts> call, @NonNull Response<Posts> response) {
                        Type collectionType = new TypeToken<ArrayList<Post>>(){}.getType();
                        Gson gson = new Gson();
                        Post[] posts = gson.fromJson(response.body().getResult(), Post[].class);

                        System.out.println(posts[0].getDescription());
                        System.out.println(posts[0].getPreviewURL());

                        desc = posts[0].getDescription();
                        url = posts[0].getPreviewURL();
                    }

                    @Override
                    public void onFailure(@NonNull Call<Posts> call, @NonNull Throwable t) {
                        //textView.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
 */
