package com.example.roomsearch123.middlework;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private final static String urlin ="http://192.168.1.4/php/";

    private static RetrofitClient rtclient;
    private Retrofit retrofit;
    public RetrofitClient()
    {
     retrofit = new Retrofit.Builder().baseUrl(urlin)
             .addConverterFactory(GsonConverterFactory.create()).build();

    }
    public static synchronized RetrofitClient getInstance()
    {
        if ( rtclient ==null)
        {
           rtclient = new RetrofitClient();

        }
        return rtclient;
    }
    public Apiinter getApp()
    {
        return retrofit.create(Apiinter.class);
    }

}
