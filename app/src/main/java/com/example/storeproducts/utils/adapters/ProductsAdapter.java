package com.example.storeproducts.utils.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.domain.entity.Product;
import com.example.storeproducts.databinding.ItemRvProductsBinding;
import com.example.storeproducts.screens.home.HomeFragmentDirections;
import com.example.storeproducts.utils.differs.ProductsDiffItemCallBack;

public class ProductsAdapter extends ListAdapter<Product, ProductsAdapter.ProductsViewHolder> {

    public ProductsAdapter() {
        super(new ProductsDiffItemCallBack());
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductsViewHolder(ItemRvProductsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    public static class ProductsViewHolder extends RecyclerView.ViewHolder {
        ItemRvProductsBinding binding;
        public ProductsViewHolder(ItemRvProductsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Product product) {
            binding.setProduct(product);

            binding.executePendingBindings();

            binding.cvProduct.setOnClickListener(view -> {
                Navigation.findNavController(view).navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(product));
            });

            Glide.with(binding.imageView).load(product.thumbnail).centerCrop().into(binding.imageView);
        }
    }
}
