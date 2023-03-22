package com.example.storeproducts.screens;



import androidx.lifecycle.ViewModel;

import com.example.domain.entity.ProductResponse;
import com.example.domain.repo.NetworkRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import retrofit2.Call;

@HiltViewModel
public class ProductsViewModel extends ViewModel {
    private NetworkRepository networkRepository;

    @Inject
    public ProductsViewModel(NetworkRepository networkRepository) {
        this.networkRepository = networkRepository;
    }

    public Call<ProductResponse> getProducts() {
        return networkRepository.getProducts();
    }
}
