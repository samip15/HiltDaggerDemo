package com.example.daggerhiltdemo.Network

import com.example.daggerhiltdemo.Model.Post
import retrofit2.http.GET

interface PostApiService {
    @GET("posts")
    suspend fun getPost() : List<Post>
}