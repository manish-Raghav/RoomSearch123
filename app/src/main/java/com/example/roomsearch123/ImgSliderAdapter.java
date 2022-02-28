package com.example.roomsearch123;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.viewpager.widget.PagerAdapter;

import com.airbnb.lottie.L;
import com.bumptech.glide.Glide;

import java.util.List;

public class ImgSliderAdapter extends PagerAdapter {

    private Context context;
    private List<String> list;
    LayoutInflater layoutInflater;

    public ImgSliderAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {

        return list.size()  ;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
      layoutInflater   =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.imagesilder,null);
        ImageView img =(ImageView) view.findViewById(R.id.imageView);
          String ls =list.get(position);
       // Glide.with(context).load("http://192.168.0.110/php/imageupload/" + ls.img.setImageResource();));
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }
}
