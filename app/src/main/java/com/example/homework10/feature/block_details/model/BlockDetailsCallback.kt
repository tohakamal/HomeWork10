package com.example.homework10.feature.block_details.model

import com.example.homework10.feature.block_list.model.Block

interface BlockDetailsCallback {
    fun onSuccess(blockDetails: Block)
    fun onError(throwable: Throwable)
}