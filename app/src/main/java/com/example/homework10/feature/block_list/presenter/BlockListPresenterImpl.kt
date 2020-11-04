package com.example.homework10.feature.block_list.presenter


import com.example.homework10.feature.block_list.model.Block
import com.example.homework10.feature.block_list.model.BlockListCallback
import com.example.homework10.feature.block_list.model.BlockListModel
import com.example.homework10.feature.block_list.model.BlockListModelImpl
import com.example.homework10.feature.block_list.view.BlockListView

class BlockListPresenterImpl(private val blockListView: BlockListView):BlockListPresenter {

    private val blockListModel : BlockListModel= BlockListModelImpl()


    override fun getBlockList() {
        blockListView.handleProgressBarVisibility(true)
        blockListModel.getBlockList(object : BlockListCallback{
            override fun onSuccess(blockList: MutableList<Block>) {
                blockListView.handleProgressBarVisibility(false)
                blockListView.onBlockListFetchSuccess(blockList)
            }

            override fun onError(throwable: Throwable) {
                blockListView.handleProgressBarVisibility(false)
                if (throwable.localizedMessage!=null)
                    blockListView.onBlockListFetchFailure(throwable.localizedMessage!!)
                else
                    blockListView.onBlockListFetchFailure("Something went Mismatch")

            }

        })
    }
}