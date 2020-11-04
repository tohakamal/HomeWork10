package com.example.homework10.network

import com.example.homework10.feature.block_list.model.Block
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BlockApiInterface {

    @GET("posts")
    fun getBlockList(): Call<MutableList<Block>>


    @GET("posts/{post_id}")
    //@GET("posts/3286")
    fun getBlockDetails(@Path("post_id") postid:Int): Call<Block>



}