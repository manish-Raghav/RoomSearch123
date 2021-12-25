package com.example.roomsearch123;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Dataupload extends AppCompatActivity {

    EditText phn, rnt, tlt, adrss, des;

    ImageView imge1, imge2, imge3;
    Button btn;
    Bitmap bitmap1, bitmap2, bitmap3;
    String email;
    private final static String surl = "http://192.168.0.111/php/RoomUpload.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dataupload);
        imge1 = findViewById(R.id.img1);
        imge2 = findViewById(R.id.img2);
        imge3 = findViewById(R.id.img3);
        btn = findViewById(R.id.upload);
        phn = findViewById(R.id.phone);
        adrss = findViewById(R.id.adress);
        rnt = findViewById(R.id.rent);
        tlt = findViewById(R.id.talent);
        des = findViewById(R.id.desi);
        getSupportActionBar().hide();
//        Bundle bundle = this.getArguments();
//        email = bundle.getString("email");
        email = getIntent().getStringExtra("email");
        //Toast.makeText(getApplicationContext(), email.toString(), Toast.LENGTH_SHORT).show();




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Serverdata();


            }
        });


        ActivityResultLauncher resultLauncher, resultLauncher1, resultLauncher2;

        resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {

                Intent intent = result.getData();
                if (intent != null) {

                    try {
//                        InputStream inputStream = getActivity().openFileInput(String.valueOf(intent.getData()));
                        bitmap1 = MediaStore.Images.Media.getBitmap(getContentResolver(), intent.getData());

                        imge1.setImageBitmap(bitmap1);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

//
            }


        });
        resultLauncher1 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {

            @Override
            public void onActivityResult(ActivityResult result) {

                Intent intent = result.getData();
                if (intent != null) {

                    try {

                        bitmap2 = MediaStore.Images.Media.getBitmap(getContentResolver(), intent.getData());

                        imge2.setImageBitmap(bitmap2);


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        resultLauncher2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {

                Intent intent = result.getData();
                if (intent != null) {

                    try {

                        bitmap3 = MediaStore.Images.Media.getBitmap(getContentResolver(), intent.getData());


                        imge3.setImageBitmap(bitmap3);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

//
            }


        });


        // 64 Algoritham


        imge1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");

                resultLauncher.launch(intent);

//                Intent intent =new Intent(Intent.ACTION_PICK);
//                intent.setType("image/*");
//
//                resultLauncher.launch(intent);
                // folow(resultLauncher);

            }

        });


        imge2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");

                resultLauncher1.launch(intent);
                //image1.setImageBitmap(arr.get(1));
                //  folow(resultLauncher);

            }

        });

        imge3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");

                resultLauncher2.launch(intent);

                // image2.setImageBitmap(arr.get(2));
                //folow(resultLauncher);

            }

        });
    }

    private void Serverdata(){

        ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
        bitmap1.compress(Bitmap.CompressFormat.JPEG, 75, byteArrayOutputStream1);
        bitmap2.compress(Bitmap.CompressFormat.JPEG, 75, byteArrayOutputStream2);
        bitmap3.compress(Bitmap.CompressFormat.JPEG, 75, byteArrayOutputStream3);
        byte[] firstimg = byteArrayOutputStream1.toByteArray();
        byte[] secondimg = byteArrayOutputStream2.toByteArray();
        byte[] thirdimg = byteArrayOutputStream3.toByteArray();
        String encode1 = Base64.encodeToString(firstimg, Base64.DEFAULT);
        String encode2 = Base64.encodeToString(secondimg, Base64.DEFAULT);
        String encode3 = Base64.encodeToString(thirdimg, Base64.DEFAULT);

//        Call<Insertdata> call = APIcreater.getInstance().getApidata().imagedata(email, phn.getText().toString(), adrss.getText().toString(), Integer.parseInt(rnt.getText().toString()), Integer.parseInt(tlt.getText().toString()), des.getText().toString(), encode1, encode2, encode3);
//        call.enqueue(new Callback<Insertdata>() {
//            @Override
//            public void onResponse(Call<Insertdata> call, Response<Insertdata> response) {
//                Toast.makeText(getContext(), response.body().getData(), Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onFailure(Call<Insertdata> call, Throwable t) {
//
//            }
//        });


        StringRequest newrequest = new StringRequest(Request.Method.POST, surl, new Response.Listener<String>() {
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
                map.put("email" ,email);
                map.put("img1" ,encode1);
                map.put("img2" ,encode2);
                map.put("img3" ,encode3);
                map.put("phone" ,phn.getText().toString().trim());
                map.put("adress" ,adrss.getText().toString().trim());
                map.put("rent" ,rnt.getText().toString().trim());
                map.put("tanentcount" ,tlt.getText().toString().trim());
                map.put("des" ,des.getText().toString().trim());


                return map;


            }
        };
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(newrequest);
    }
}