package com.example.roomsearch123;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    BottomNavigationView bottemview;
    Intent intent ;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        bottemview = findViewById(R.id.bottem);
        searchView = findViewById(R.id.search);

        //  recyclerView = findViewById(R.id.re);


        // recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // sear =findViewById(R.id.sear);
        //  layout =findViewById(R)
        getSupportFragmentManager().beginTransaction().replace(R.id.mani,new Interactiveview()).commit();// Attached fragment.

        bottemview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Fragment temp =null;
                switch (item.getItemId())
                {
                    case R.id.upload:
                        // temp =new Uploadfrag();
                            intent =new Intent(Home.this ,SignupActivity.class);
                          startActivity(intent);
                        break;
                    case R.id.profile:
                           intent  = new Intent(Home.this, Ptofile.class);
                           startActivity(intent);
                        break;
                }

                return true;
            }
        });

    }
}