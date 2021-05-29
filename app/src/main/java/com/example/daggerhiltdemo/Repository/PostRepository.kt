package com.example.daggerhiltdemo.Repository

import com.example.daggerhiltdemo.Model.Post
import com.example.daggerhiltdemo.Network.PostServiceImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import javax.inject.Inject

class PostRepository
@Inject
constructor(private val postApiServiceImp: PostServiceImp) {
    // flow aync task to get post
    fun getPost(): Flow<List<Post>> = flow {
        val response = postApiServiceImp.getPost()
        //gives data in sequence in screen
        emit(response)
    }.flowOn(Dispatchers.IO)
}