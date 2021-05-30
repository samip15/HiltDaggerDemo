package com.example.daggerhiltdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.daggerhiltdemo.ViewModel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var txtId: TextView
    lateinit var txtTitle: TextView
    lateinit var txtBody: TextView
    private val postViewModel: PostViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postViewModel.response.observe(this, Observer { response ->
            txtId = findViewById(R.id.tv_id)
            txtTitle = findViewById(R.id.tv_title)
            txtBody = findViewById(R.id.tv_body)
            txtId.text = response[0].id
            txtTitle.text = response[0].title
            txtBody.text = response[0].body
            Log.d("main", "${response[0].body}")
        })
    }
}