package com.example.roomsearch123;

import  android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class Adapterdata extends RecyclerView.Adapter<Adapterdata.myviewholderd> {


   // private List<InteractiveModeldata> data;
     InteractiveModeldata[] data;
    Context context;
    public Adapterdata( /*List<InteractiveModeldata> data*/   InteractiveModeldata[] data , Context context) {
        this.data = data;
        this.context = context;
    }



    @NonNull
    @Override
    public myviewholderd onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.singleview,parent,false);
        return new myviewholderd(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholderd holder, int position) {


        InteractiveModeldata obj = data[position];
        //String s1  = obj.getImg1();
         Glide.with(context).load("http://192.168.1.3/php/imageupload/" +obj.getImg3()).into(holder.imgw);


          //Glide.with(context).load("http://192.168.1.7/php/imageupload" + obj.getImg2()).into(holder.imgw2);

      //  Toast.makeText(context, obj.getImg1(), Toast.LENGTH_SHORT).show();
          holder.rent.setText("₹"+obj.getRent());
        holder.count.setText("tanent-" + obj.getTanentcount());
          holder.adrss.setText(obj.getAdress());


          holder.imgw.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                    Intent intent = new Intent(context, ViewData.class);
                    intent.putExtra("image1",obj.getImg1());
                    intent.putExtra("image2",obj.getImg2());
                   intent.putExtra("image1",obj.getImg3());
                   intent.putExtra("Email",obj.getEmail());
                   intent.putExtra("adress", obj.getAdress());
                     intent.putExtra("phone",obj.getPhone());
                     intent.putExtra("Desc",obj.getDis());
                      intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                     context.startActivity(intent);
              }
          });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class myviewholderd extends RecyclerView.ViewHolder{
        ImageView imgw ,imgw2;
        TextView rent , count,adrss;

        public myviewholderd(@NonNull View itemView)
        {
            super(itemView);
            imgw =itemView.findViewById(R.id.cimg);
            imgw2 =itemView.findViewById(R.id.imag2);
            rent =itemView.findViewById(R.id.crent);
            count =itemView.findViewById(R.id.ctanent);
            adrss =itemView.findViewById(R.id.cadress);


        }
    }
}