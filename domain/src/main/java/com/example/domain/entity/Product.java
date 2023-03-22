package com.example.domain.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Product implements Parcelable {
    public int id;
    public String title;
    public String description;
    public int price;
    public double discountPercentage;
    public double rating;
    public int stock;
    public String brand;
    public String category;
    public String thumbnail;
    public ArrayList<String> images;

    protected Product(Parcel in) {
        id = in.readInt();
        title = in.readString();
        description = in.readString();
        price = in.readInt();
        discountPercentage = in.readDouble();
        rating = in.readDouble();
        stock = in.readInt();
        brand = in.readString();
        category = in.readString();
        thumbnail = in.readString();
        images = in.createStringArrayList();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeInt(price);
        parcel.writeDouble(discountPercentage);
        parcel.writeDouble(rating);
        parcel.writeInt(stock);
        parcel.writeString(brand);
        parcel.writeString(category);
        parcel.writeString(thumbnail);
        parcel.writeStringList(images);
    }
}
