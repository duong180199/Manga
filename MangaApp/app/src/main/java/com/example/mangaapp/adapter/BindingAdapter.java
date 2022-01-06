package com.example.mangaapp.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mangaapp.R;
import com.squareup.picasso.Picasso;

public class BindingAdapter {
    @androidx.databinding.BindingAdapter("android:imageURL")
    public static void setImageURL(ImageView imageView, String URL){
//        Picasso.get().load(URL).into(imageView);
        Glide.with(imageView.getContext()).load(URL).into(imageView);
    }
    @androidx.databinding.BindingAdapter("android:text")
    public static void setFloat(TextView textView, float value){
        textView.setText(String.valueOf(value));
    }

    @androidx.databinding.BindingAdapter("android:textInt")
    public static void setInt(TextView textView, int value){
        textView.setText(String.valueOf(value));
    }
}
