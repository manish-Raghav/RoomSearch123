package com.example.roomsearch123;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

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

//        byte[] imgurl1 = Base64.decode(data.get(position).getImage1() ,Base64.DEFAULT);
//        Bitmap bitmap = BitmapFactory.decodeByteArray(imgurl1,0,imgurl1.length);
//        Glide.with(context).load(bitmap).into(holder.imgw);
//        //holder.imgw.setImageBitmap(bitmap);
//          holder.rent.setText(data.get(position).getRent());
//          holder.count.setText(data.get(position).getTenantcount());
//          holder.adrss.setText(data.get(position).getAdress());




        InteractiveModeldata obj = data[position];
         Glide.with(context).load("http://192.168.0.111/php/imageupload/" +obj.getImage1()).into(holder.imgw);
          holder.rent.setText(obj.getRent());
        holder.count.setText(obj.getTenantcount());
          holder.adrss.setText(obj.getAdress());
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class myviewholderd extends RecyclerView.ViewHolder{
        ImageView imgw;
        TextView rent , count,adrss;

        public myviewholderd(@NonNull View itemView)
        {
            super(itemView);
            imgw =itemView.findViewById(R.id.cimg);
            rent =itemView.findViewById(R.id.crent);
            count =itemView.findViewById(R.id.ctelant);
            adrss =itemView.findViewById(R.id.cadress);


        }
    }
}