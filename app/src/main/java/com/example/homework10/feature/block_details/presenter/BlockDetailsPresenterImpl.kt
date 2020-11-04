package com.example.homework10.feature.block_details.presenter

import com.example.homework10.feature.block_details.model.*
import com.example.homework10.feature.block_details.view.BlockDetailsView
import com.example.homework10.feature.block_list.model.Block

class BlockDetailsPresenterImpl(private val blockDetailsView:BlockDetailsView):BlockDetailsPresenter {
    
    private val blockDetailsModel:BlockDetailsModel=BlockDetailsModelImpl()

    override fun getBlockDetails(id:Int) {
        blockDetailsView.handleProgressBarVisibility(true)
        blockDetailsModel.getBlockDetails(id,object : BlockDetailsCallback {
            override fun onSuccess(blockDetails: Block) {
                blockDetailsView.handleProgressBarVisibility(false)
                blockDetailsView.onBlockDetailsFetchSuccess(blockDetails)
            }

            override fun onError(errorMessage: Throwable) {
               // blockDetailsView.handleProgressBarVisibility(VISIBLE)
                if (errorMessage.localizedMessage != null)
                    blockDetailsView.onBlockDetailsFetchFailure(errorMessage.localizedMessage!!)
                else
                    blockDetailsView.onBlockDetailsFetchFailure("Something went wrong!")
            }
            
        })
    }
}