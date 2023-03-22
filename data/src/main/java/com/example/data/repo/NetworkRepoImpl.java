package com.example.data.repo;

import com.example.data.remote.ApiService;
import com.example.domain.entity.ProductResponse;
import com.example.domain.repo.NetworkRepository;

import java.util.List;

import retrofit2.Call;

public class NetworkRepoImpl implements NetworkRepository {
    private ApiService apiService;
    public NetworkRepoImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Call<ProductResponse> getProducts() {
        return apiService.getProducts();
    }
}
