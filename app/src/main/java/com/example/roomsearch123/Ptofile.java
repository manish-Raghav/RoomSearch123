package com.example.roomsearch123;

import static com.example.roomsearch123.R.menu.menu_mani;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Ptofile extends AppCompatActivity {
       TextView tx ,tbutton,xt1  ;
    SharedPreferences sp;
    private final static String key_name = "name";
    private final static String key_email ="email";
    private final static String sharedname ="mydata";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_profile);
        tx=findViewById(R.id.t1);
       xt1 =findViewById(R.id.ptx2);
        tbutton=findViewById(R.id.t2);
        Toolbar tl = findViewById(R.id.toolbar);
        tl.setTitle("              ROOM SEARCH");
         setSupportActionBar(tl);

       //  getSupportActionBar().hide();

        sp =getSharedPreferences(sharedname,MODE_PRIVATE);

        String getnm = sp.getString(key_name,null);
        String seteml = sp.getString(key_email ,null);
        tx.setText("Name :" + getnm );
        xt1.setText("Email :" + seteml );

        tbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor ed =sp.edit();
                if (sp.contains(key_email) && sp.contains(key_name))
                {
                    ed.remove(key_email);
                    ed.remove(key_name);
                    tx.setText("");
                    ed.commit();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(menu_mani,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemid = item.getItemId();
        if (itemid ==R.id.del)
        {
            Toast.makeText(this, "Running mode", Toast.LENGTH_SHORT).show();
        }
        else if (itemid == R.id.sign)
        {

        }
        return true;

    }
}