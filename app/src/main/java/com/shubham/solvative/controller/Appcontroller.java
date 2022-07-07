package com.shubham.solvative.controller;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Appcontroller extends Application {

    private static Appcontroller appcontroller ;
    private RequestQueue requestQueue;
    public static String TAG = Appcontroller.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        appcontroller = this;
    }

    public Appcontroller() {
    }

    public static synchronized Appcontroller getInstance() {
       return appcontroller;
    }

    public RequestQueue getRequestQueue(){
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag)? TAG: tag);
        getRequestQueue().add(req);
    }

}
