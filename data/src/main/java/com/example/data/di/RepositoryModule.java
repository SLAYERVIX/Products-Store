package com.example.data.di;

import com.example.data.remote.ApiService;
import com.example.data.repo.NetworkRepoImpl;
import com.example.domain.repo.NetworkRepository;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {
    @Provides
    NetworkRepository providesNetworkRepo(ApiService apiService) {
        return new NetworkRepoImpl(apiService);
    }
}
