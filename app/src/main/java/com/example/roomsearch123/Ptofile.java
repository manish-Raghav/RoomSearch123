package com.example.roomsearch123;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class Ptofile extends AppCompatActivity {
       TextView tx ,tbutton;
    SharedPreferences sp;
    private final static String key_name = "name";
    private final static String key_email ="email";
    private final static String sharedname ="mydata";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_profile);
        tx=findViewById(R.id.t1);
        tbutton=findViewById(R.id.t2);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        sp =getSharedPreferences(sharedname,MODE_PRIVATE);

        String getnm = sp.getString(key_name,null);
        tx.setText(getnm + " view profile");
        tbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor ed =sp.edit();
                if (sp.contains(key_email) && sp.contains(key_name))
                {
                    ed.remove(key_email);
                    ed.remove(key_name);
                    tx.setText("");
                }
            }
        });

    }

}