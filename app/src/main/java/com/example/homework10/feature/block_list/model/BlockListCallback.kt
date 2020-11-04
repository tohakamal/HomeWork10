package com.example.homework10.feature.block_list.model

interface BlockListCallback {
    fun onSuccess(blockList: MutableList<Block>)
    fun onError(throwable: Throwable)
}