package com.example.yourdoctor.helpers;

import com.loopj.android.http.AsyncHttpClient;

public class ApiHelper {
    private static final String API_URL = "http://192.168.1.4:5100";
    private AsyncHttpClient client;

    public ApiHelper() {
        this.client = new AsyncHttpClient();
    }

    public String getApiUrl() {
        return API_URL;
    }

    public AsyncHttpClient getClient() {
        return this.client;
    }
}
