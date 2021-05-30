package com.example.daggerhiltdemo.di

import com.example.daggerhiltdemo.Network.PostApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Provides
    fun provideBaseUrl(): String = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun providesRetrofit(baseUrl: String): Retrofit =
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

    @Provides
    fun providesApiService(retrofit: Retrofit): PostApiService =
            retrofit.create(PostApiService::class.java)
}