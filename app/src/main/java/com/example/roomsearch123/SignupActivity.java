package com.example.roomsearch123;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    EditText name, email;
    private final static String url = "http://192.168.0.111/php/Signup.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);



        getSupportActionBar().hide();
        btn = findViewById(R.id.signupbt);
        name = findViewById(R.id.nm);
        email = findViewById(R.id.em);
        //        Bundle bundel = new Bundle();
        //        bundel.putString("email", email.getText().toString());
        //        Imagedataupload fb = new Imagedataupload();
        //        fb.setArguments(bundel);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(SignupActivity.this  ,Dataupload.class);
                intent.putExtra("email" , email.getText().toString().trim());
                startActivity(intent);

                upload();


                //                Imagedataupload up = new Imagedataupload();
                // getChildFragmentManager().beginTransaction().replace(R.id.mani, fb).commit();
                //    getSupportFragmentManager().beginTransaction().replace(R.id.mk,up).commit();


            }
        }   );

    }

    private void upload() {
        String aemail = email.getText().toString().trim();
        String aname = name.getText().toString().trim();
        //        Call<dataclass> call =APIcreater.getInstance().getApidata().adddata( aemail,aname);
        //        call.enqueue(new Callback<dataclass>() {
        //            @Override
        //            public void onResponse(Call<dataclass> call, Response<dataclass> response) {
        //                Toast.makeText(getApplicationContext(),response.body().getData(), Toast.LENGTH_SHORT).show();
        //            }
        //
        //            @Override
        //            public void onFailure(Call<dataclass> call, Throwable t) {
        //                Toast.makeText(getApplicationContext(), "problem in your API", Toast.LENGTH_LONG).show();
        //            }
        //        });
        //
        //    }


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
                Map<String ,String> map =new HashMap<>();
                map.put("Email" ,aemail);
                map.put("Name" ,aname);



                return map;


            }
        };
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(newrequest);
}
}