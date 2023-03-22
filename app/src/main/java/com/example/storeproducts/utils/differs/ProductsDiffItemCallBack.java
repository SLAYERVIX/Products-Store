package com.example.storeproducts.utils.differs;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.domain.entity.Product;

import java.util.Objects;

public class ProductsDiffItemCallBack extends DiffUtil.ItemCallback<Product> {
    @Override
    public boolean areItemsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
        return oldItem.id == newItem.id;
    }

    @Override
    public boolean areContentsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
        return Objects.equals(oldItem,newItem);
    }
}
