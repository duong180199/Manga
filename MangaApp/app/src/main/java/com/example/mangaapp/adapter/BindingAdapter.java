package com.example.mangaapp.adapter;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingMethod;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

//faild
public class BindingAdapter {
    @androidx.databinding.BindingAdapter("android:imageURL")
    public static void setImageURL(ImageView imageView, String URL){
        Picasso.get().load(URL).into(imageView);
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
