package com.example.data.remote;

import com.example.domain.entity.ProductResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("/products")
    Call<ProductResponse> getProducts();

    @GET("/products/{id}")
    Call<ProductResponse> getProductDetails(@Path("id") int id);
}
