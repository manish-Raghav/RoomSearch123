package com.example.roomsearch123;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Singleactivity extends AppCompatActivity {
    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.singleview);



        cardView = findViewById(R.id.homecard);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intentm = new Intent(.this ,Cardshow_img.class);
//                startActivity(intentm);
            }
        });



    }
}