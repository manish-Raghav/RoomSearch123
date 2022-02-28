package com.example.roomsearch123;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Interactiveview extends Fragment {

    private final static String url ="http://192.168.0.110/php/RoomAccess.php";
    RecyclerView recyclerView;
     List<InteractiveModeldata> list;
     Adapterdata myadapter;
    InteractiveModeldata interobject;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View  view = inflater.inflate(R.layout.fragment_interactiveview, container, false);


        recyclerView = view.findViewById(R.id.re);

        //((AppCompatActivity)getActivity()).getSupportActionBar();
        GridLayoutManager gridLayoutManager =new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);

            Showdata();




        return view;
    }

    private void Showdata() {

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {



                  GsonBuilder gsonBuilder = new GsonBuilder();
                  Gson gson = gsonBuilder.create();
                  InteractiveModeldata[] data = gson.fromJson(response,InteractiveModeldata[].class);

                   recyclerView .setAdapter(new Adapterdata(data ,getContext()));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(request);
    }
}