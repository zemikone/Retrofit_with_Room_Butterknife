package com.example.zemikone.retrofit.Model;

import com.google.gson.annotations.SerializedName;

public class Request {

    @SerializedName("key")
    String key;

    @SerializedName("p")
    String p;

    public Request() {
    }

    public Request(String key, String p) {
        this.key = key;
        this.p = p;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }
}
