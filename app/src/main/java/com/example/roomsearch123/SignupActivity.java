package com.example.roomsearch123;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {
    Button btn;
    EditText name, kemail ;
    TextView txm;
    SharedPreferences sp;
    private final static String url = "http://192.168.1.3/php/Signup.php";
    private final static String key_name = "name";
    private final static String key_email ="email";
    private final static String sharedname ="mydata";
    Intent intent;
    String aemail ;
    String  aname  ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


       // getSupportActionBar().hide();
        btn = findViewById(R.id.signupbt);
        name = findViewById(R.id.nm);
        kemail = findViewById(R.id.em);
        txm = findViewById(R.id.te2);






        sp = getSharedPreferences(sharedname, MODE_PRIVATE);
        String getem = sp.getString(key_email, null);
        String getnm = sp.getString(key_name, null);
        if (getem != null && getnm != null) {
            intent = new Intent(SignupActivity.this, Dataupload.class);
            startActivity(intent);
            finish();
        }









//        sp = getSharedPreferences(sharedname, MODE_PRIVATE);
//        String getem = sp.getString(key_email, null);
//        String getnm = sp.getString(key_name, null);
//        if (getem != null && getnm != null) {
//            intent = new Intent(SignupActivity.this, Dataupload.class);
//            startActivity(intent);
//            finish();
//        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


             //   Toast.makeText(getApplicationContext(), aemail.toString(), Toast.LENGTH_SHORT).show();
                aemail = kemail.getText().toString().trim();
                aname = name.getText().toString().trim();

                if (!aemail.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(aemail).matches()) {

                    prephere();
                    upload(aemail, aname);
                    intent = new Intent(SignupActivity.this, Dataupload.class);
                    intent.putExtra("email", kemail.getText().toString().trim());
                    intent.putExtra("myname", name.getText().toString().trim());
                    startActivity(intent);


                }
                else {
                    txm.setText("please enter valid Email");
                }
            }


        });




    }

    private void prephere() {


        SharedPreferences.Editor editor =sp.edit();
        editor.putString(key_name,aemail);
        editor.putString(key_email,aname);
        editor.apply();
    }

    private void upload(String aemail, String aname) {
//        String aemail = kemail.getText().toString().trim();
//        String aname = name.getText().toString().trim();
//        if (!aemail.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(aemail).matches()) {


            StringRequest newrequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();

                }
            }

            ) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> map = new HashMap<>();
                    map.put("Email", aemail);
                    map.put("Name", aname);


                    return map;


                }
            };
            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
            queue.add(newrequest);
        }



}