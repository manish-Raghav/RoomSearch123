package com.example.roomsearch123.middlework;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Apiinter {

    @FormUrlEncoded
    @POST("Viewdata.php")
    Call<Vstremail> adddata(@Field("vemail") String vemail);



    @GET("RoomAccess.php")
    Call<List<minidata>> getviewdata();
}
