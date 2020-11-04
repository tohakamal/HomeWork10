package com.example.homework10.feature.block_details.model

interface BlockDetailsModel {
    fun getBlockDetails(id:Int,blockDetailsCallback: BlockDetailsCallback)
}