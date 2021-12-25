package com.example.roomsearch123;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    private final static String url ="http://192.168.0.111/php/fetchImages.php";
    RecyclerView recyclerView;
     List<InteractiveModeldata> list;
     Adapterdata myadapter;
     InteractiveModeldata interobject;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view = inflater.inflate(R.layout.fragment_interactiveview, container, false);
        //((AppCompatActivity)getActivity()).getSupportActionBar();
        recyclerView = view.findViewById(R.id.re);



        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        myadapter = new Adapterdata(getContext(), list);
        recyclerView.setAdapter(myadapter);
        Showdata();

        return view;
    }

    private void Showdata() {

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);

                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    for (int i = 0;i<jsonArray.length();i++)
                    {
                        JSONObject object = jsonArray.getJSONObject(i);
                        String email= object.getString("email");
                        String adress = object.getString("adress");
                        String phone = object.getString("phone");
                        String rent = object.getString("rent");
                        String count = object.getString("tanentcount");
                        String des = object.getString("des");
                        String img1 = object.getString("img1");
                        String img2 = object.getString("img2");
                        String img3 = object.getString("img3");
                        String imgurl1 = "http://192.168.0.111/php/imageupload/"+img1;
                        String imgurl2 = "http://192.168.0.111/php/imageupload/"+img2;
                        String imgurl3 = "http://192.168.0.111/php/imageupload/"+img3;

                        interobject =   new InteractiveModeldata(email,adress,phone,rent,count,des,imgurl1,imgurl2,imgurl3);
                        list.add(interobject);
                        myadapter.notifyDataSetChanged();



                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

//                GsonBuilder gsonBuilder = new GsonBuilder();
//                Gson gson = gsonBuilder.create();
//                InteractiveModeldata[] data = gson.fromJson(response,InteractiveModeldata[].class);
//
//                recyclerView .setAdapter(new Adapterdata(data ,getContext()));
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