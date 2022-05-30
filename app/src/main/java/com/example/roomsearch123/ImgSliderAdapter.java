//package com.example.roomsearch123;
//
//import android.content.Context;
//import android.provider.ContactsContract;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//
//import androidx.annotation.NonNull;
//import androidx.lifecycle.ViewTreeViewModelStoreOwner;
//import androidx.viewpager.widget.PagerAdapter;
//
//import com.airbnb.lottie.L;
//import com.bumptech.glide.Glide;
//import com.example.roomsearch123.R;
//
//import java.util.List;
//
//public class ImgSliderAdapter extends PagerAdapter {
//
//    private Context context;
//    InteractiveModeldata[] data;
//    LayoutInflater layoutInflater;
//
//    public ImgSliderAdapter(Context context, InteractiveModeldata[] data) {
//        this.context = context;
//        this.data = data;
//    }
//
//    @Override
//    public int getCount() {
//
//        return data.length ;
//    }
//
//    @Override
//    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//        return view ==object;
//    }
//
//    @NonNull
//    @Override
//    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//      layoutInflater   =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view=layoutInflater.inflate(R.layout.imagesilder,null);
//        ImageView img =(ImageView) view.findViewById(R.id.imageView);
//        InteractiveModeldata obj = data[position];
//       // Glide.with(context).load("http://192.168.0.110/php/imageupload/" + ls.img.setImageResource();));
//        return view;
//
//    }
//
//    @Override
//    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
//    }
//}
