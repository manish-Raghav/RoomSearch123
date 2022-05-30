package com.example.roomsearch123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.roomsearch123.middlework.RetrofitClient;
import com.example.roomsearch123.middlework.Vstremail;
import com.example.roomsearch123.middlework.minidata;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewData extends AppCompatActivity {
    List<String> list;
    TextView t1, t2, t3,t4;
    ImageView imgm1 ,imgn2 ,imgm3;
     Context context;
    String email = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dataview);
        t1 = findViewById(R.id.imtx1);
        t2 = findViewById(R.id.imt2);
        t3 = findViewById(R.id.imt3);
        t4 = findViewById(R.id.imt4);
        imgm1 =findViewById(R.id.imv1);
        imgn2 =findViewById(R.id.imv2);
        imgm3 =findViewById(R.id.imv3);
       // getSupportActionBar().hide();
        t1.setText(getIntent().getStringExtra("Email"));
        t2.setText(getIntent().getStringExtra("phone"));
        t3.setText(getIntent().getStringExtra("adress"));
        t4.setText(getIntent().getStringExtra("Desc"));


         //email= getIntent().getStringExtra("Email");
        //Toast.makeText(getApplicationContext(), email.toString(), Toast.LENGTH_SHORT).show();
         // process();

//        list =new ArrayList<>();
          String s1 = getIntent().getStringExtra("image1");
        String s2 = getIntent().getStringExtra("image2");
        String s3 = getIntent().getStringExtra("image3");
        Toast.makeText(this, s1.toString(), Toast.LENGTH_SHORT).show();
        //Glide.with(context).load("http://192.168.1.3/php/imageupload/" + s1).into(imgm1);
        Glide.with(this).load("http://192.168.1.3/php/imageupload/")
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(imgm1);
//        String s2 = "http://192.168.0.107/php/imageupload/" +getIntent().getStringExtra("image2") ;
//        String s3 = "http://192.168.0.107/php/imageupload/" +getIntent().getStringExtra("image3") ;
//        list.add(s1);
//        list.add(s2);
//        list.add(s3);



//        Call<List<minidata>> call = RetrofitClient.getInstance().getApp().getviewdata();
//        call.enqueue(new Callback<List<minidata>>() {
//            @Override
//            public void onResponse(Call<List<minidata>> call, Response<List<minidata>> response) {
//
////                GsonBuilder gsonBuilder = new GsonBuilder();
////                Gson gson = gsonBuilder.create();
////                minidata[] data = gson.fromJson(response,minidata[].class);
//                List<minidata> mdata = response.body();
//                //Toast.makeText(getApplicationContext(),response.body(), Toast.LENGTH_SHORT).show();
//                //for(int i =0;i<mdata.size();i++) {
//
//                    t1.setText(mdata.get(0).getSname());
//                    t2.setText(mdata.get(0).getPhone());
//                    t3.setText(mdata.get(0).getSadree());
//                    t4.setText(mdata.get(0).getSdes());
//                //}
//
//
//            }
//
//            @Override
//            public void onFailure(Call<List<minidata>> call, Throwable t) {
//
//            }
//        });






    }

    private void process() {
        Call<Vstremail> call = RetrofitClient.getInstance().getApp().adddata(email);
        call.enqueue(new Callback<Vstremail>() {
            @Override
            public void onResponse(Call<Vstremail> call, Response<Vstremail> response) {
                Toast.makeText(getApplicationContext(), response.body().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Vstremail> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}