package com.example.developerslife.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("previewURL")
    @Expose
    private String previewURL;

    public Post(int id, String description, String previewURL) {
        this.id = id;
        this.description = description;
        this.previewURL = previewURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }
}

/*
{"result":
[
{
    "id":17088,
    "description":"Накануне дедлайна",
    "votes":5,
    "author":"w3lifer",
    "date":"May 17, 2021 12:47:20 PM",
    "gifURL":"http://static.devli.ru/public/images/gifs/202105/338eec95-f956-4aa6-8844-219166979cc2.gif",
    "gifSize":637391,
    "previewURL":"https://static.devli.ru/public/images/previews/202105/338eec95-f956-4aa6-8844-219166979cc2.jpg",
    "videoURL":"http://static.devli.ru/public/images/v/202105/338eec95-f956-4aa6-8844-219166979cc2.mp4",
    "videoPath":"/public/images/v/202105/338eec95-f956-4aa6-8844-219166979cc2.mp4",
    "videoSize":172526,
    "type":"gif",
    "width":"232",
    "height":"154",
    "commentsCount":0,
    "fileSize":637391,
    "canVote":false
},
{
"id":17075,
"description":"Правильное использование фичи библиотеки из не самого доверенного исчтоника.",
"votes":8,
"author":"Alex_158",
"date":"Oct 20, 2020 1:33:10 PM",
"gifURL":"http://static.devli.ru/public/images/gifs/202009/3c2dbbe9-da67-4df3-8790-0fa3d995ceeb.gif",
"gifSize":2039413,
"previewURL":"https://static.devli.ru/public/images/previews/202009/3c2dbbe9-da67-4df3-8790-0fa3d995ceeb.jpg",
"videoURL":"http://static.devli.ru/public/images/v/202009/3c2dbbe9-da67-4df3-8790-0fa3d995ceeb.mp4",
"videoPath":"/public/images/v/202009/3c2dbbe9-da67-4df3-8790-0fa3d995ceeb.mp4",
"videoSize":1380587,
"type":"gif",
"width":"610",
"height":"255",
"commentsCount":2,
"fileSize":2039413,
"canVote":false
},
{
"id":17073,"description":".hairstyle {margin-top: -10px;}","votes":16,"author":"agentsib","date":"Jul 27, 2020 2:25:49 PM","gifURL":"http://static.devli.ru/public/images/gifs/202007/f1e78b48-3bf9-4184-8ec5-471ee80f3f76.gif","gifSize":8436134,"previewURL":"https://static.devli.ru/public/images/previews/202007/f1e78b48-3bf9-4184-8ec5-471ee80f3f76.jpg","videoURL":"http://static.devli.ru/public/images/v/202007/f1e78b48-3bf9-4184-8ec5-471ee80f3f76.mp4","videoPath":"/public/images/v/202007/f1e78b48-3bf9-4184-8ec5-471ee80f3f76.mp4","videoSize":536516,"type":"gif","width":"320","height":"320","commentsCount":1,"fileSize":8436134,"canVote":false},{"id":17072,"description":"Нашел в API крутую фичу","votes":15,"author":"analizatar","date":"Jul 20, 2020 10:05:42 AM","gifURL":"http://static.devli.ru/public/images/gifs/202007/1687d750-5332-4cef-b4d9-0e1669523762.gif","gifSize":9574611,"previewURL":"https://static.devli.ru/public/images/previews/202007/1687d750-5332-4cef-b4d9-0e1669523762.jpg","videoURL":"http://static.devli.ru/public/images/v/202007/1687d750-5332-4cef-b4d9-0e1669523762.mp4","videoPath":"/public/images/v/202007/1687d750-5332-4cef-b4d9-0e1669523762.mp4","videoSize":2581105,"type":"gif","width":"460","height":"674","commentsCount":0,"fileSize":9574611,"canVote":false},{"id":17071,"description":"Собес \u003c- HR \u003c- разраб","votes":4,"author":"w3lifer","date":"Jun 10, 2020 9:52:37 AM","gifURL":"http://static.devli.ru/public/images/gifs/202005/4491a587-061f-47aa-85cd-2082ff89ab97.gif","gifSize":8354847,"previewURL":"https://static.devli.ru/public/images/previews/202005/4491a587-061f-47aa-85cd-2082ff89ab97.jpg","videoURL":"http://static.devli.ru/public/images/v/202005/4491a587-061f-47aa-85cd-2082ff89ab97.mp4","videoPath":"/public/images/v/202005/4491a587-061f-47aa-85cd-2082ff89ab97.mp4","videoSize":861516,"type":"gif","width":"480","height":"300","commentsCount":0,"fileSize":8354847,"canVote":false}],"totalCount":12923}
 */