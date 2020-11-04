package com.example.homework10.feature.block_list.view

import com.example.homework10.feature.block_list.model.Block

interface BlockListView {

    fun handleProgressBarVisibility(isVisible: Boolean)
    fun onBlockListFetchSuccess(blockList: MutableList<Block>)
    fun onBlockListFetchFailure(errorMessage: String)
}