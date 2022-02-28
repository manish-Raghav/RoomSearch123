package com.example.roomsearch123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ViewData extends AppCompatActivity {
    List<String> list;
    TextView t1, t2, t3;
   Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        t1 = findViewById(R.id.tx1);
        t2 = findViewById(R.id.tx2);
        t3 = findViewById(R.id.tx3);
        getSupportActionBar().hide();
        t1.setText(getIntent().getStringExtra("Name"));
        t2.setText(getIntent().getStringExtra("phone"));
        t3.setText(getIntent().getStringExtra("Desc"));
        list =new ArrayList<>();
        String s1 = "http://192.168.0.107/php/imageupload/" +getIntent().getStringExtra("image1") ;
        String s2 = "http://192.168.0.107/php/imageupload/" +getIntent().getStringExtra("image2") ;
        String s3 = "http://192.168.0.107/php/imageupload/" +getIntent().getStringExtra("image3") ;
        list.add(s1);
        list.add(s2);
        list.add(s3);
        ImgSliderAdapter obj = new ImgSliderAdapter(context ,list);
        Toast.makeText(this,s1.toString(),Toast.LENGTH_LONG).show();




    }
}