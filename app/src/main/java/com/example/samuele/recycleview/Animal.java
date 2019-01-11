package com.example.samuele.recycleview;

import android.net.Uri;

public class Animal {

    private String name;
    private Uri uriImg = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUriImg(Uri uriImg) {
        this.uriImg = uriImg;
    }

    public Uri getUriImg() {
        return uriImg;
    }
}
