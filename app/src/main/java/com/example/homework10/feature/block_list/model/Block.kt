package com.example.homework10.feature.block_list.model
import java.io.Serializable

data class Block(
    val id:Int,
    val jetpack_featured_media_url:String,
    val title:Title,
    val author:String,
    val content:Description
    //val modified:String,
):Serializable{
    data class Title(
        val rendered:String
    )
    data class Description(
        val rendered: String
    )
}