package com.example.firebaseimages;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.PagerAdapter;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

public class SlidePageAdapter extends PagerAdapter {

    private Context context;
    private List<Upload> arrayList;

    public SlidePageAdapter(ImagesActivity mainActivity, List<Upload> apiModelArrayList) {
        this.context=mainActivity;
        this.arrayList=apiModelArrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = Objects.requireNonNull(layoutInflater).inflate(R.layout.image_item, container, false);
        Upload data=arrayList.get(position);

        final ImageView image = view.findViewById(R.id.image);
        final TextView heading = view.findViewById(R.id.subheading);
        final TextView content = view.findViewById(R.id.content);

        Picasso.get().load(data.getImageUrl()).into(image);
        heading.setText("FactShots");
        container.addView(view);
        content.setText(data.getName());
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((FrameLayout) object);
    }
}
