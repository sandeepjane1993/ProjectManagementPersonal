package com.example.sande.projectmanagementpersonal.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {


    String base_url;

    public ApiModule(String base_url) {
        this.base_url = base_url;
    }

    @Singleton
    @Provides
    public Retrofit providesRetrofit()
    {
        return new Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(base_url)
                .build();
    }

}
