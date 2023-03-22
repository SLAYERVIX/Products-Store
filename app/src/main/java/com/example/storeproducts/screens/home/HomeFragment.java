package com.example.storeproducts.screens.home;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.domain.entity.ProductResponse;
import com.example.storeproducts.screens.ProductsViewModel;
import com.example.storeproducts.databinding.FragmentHomeBinding;
import com.example.storeproducts.utils.adapters.ProductsAdapter;

import dagger.hilt.android.AndroidEntryPoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@AndroidEntryPoint
public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ProductsViewModel productsViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productsViewModel = new ViewModelProvider(this).get(ProductsViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater,container,false);

        ProductsAdapter adapter = new ProductsAdapter();
        binding.rvProducts.setAdapter(adapter);

        productsViewModel.getProducts().enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                adapter.submitList(response.body().products);
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {

            }
        });

        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}