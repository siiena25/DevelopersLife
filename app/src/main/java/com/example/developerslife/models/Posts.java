package com.example.developerslife.models;

import com.example.developerslife.models.Post;
import com.google.gson.JsonArray;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Posts {
    private ArrayList<Post> posts;

    @SerializedName("result")
    @Expose
    private JsonArray result;

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public int getCountOfPosts() {
        return posts.size();
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public JsonArray getResult() {
        return result;
    }

    public void setResult(JsonArray result) {
        this.result = result;
    }
}
