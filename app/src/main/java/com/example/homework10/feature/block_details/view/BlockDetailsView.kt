package com.example.homework10.feature.block_details.view


import com.example.homework10.feature.block_list.model.Block

interface BlockDetailsView {
    fun handleProgressBarVisibility(isVisible: Boolean)
    fun onBlockDetailsFetchSuccess(block: Block)
    fun onBlockDetailsFetchFailure(errorMessage: String)
}