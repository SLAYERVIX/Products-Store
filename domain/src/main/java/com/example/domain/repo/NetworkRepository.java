package com.example.domain.repo;


import com.example.domain.entity.ProductResponse;

import java.util.List;

import retrofit2.Call;

public interface NetworkRepository {
    Call<ProductResponse> getProducts();
}
