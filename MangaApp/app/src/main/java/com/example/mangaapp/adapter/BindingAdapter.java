package com.example.mangaapp.adapter;


import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingMethod;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;


public class BindingAdapter {
    @androidx.databinding.BindingAdapter("imageURL")
    public static void setImageURL(ImageView imageView, String URL){
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
