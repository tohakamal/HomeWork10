package com.example.homework10.feature.block_list.model

import com.example.homework10.network.BlockApiInterface
import com.example.homework10.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BlockListModelImpl:  BlockListModel {

    private val apiInterface = RetrofitClient.getClient().create(BlockApiInterface::class.java)
    private val call = apiInterface.getBlockList()

    override fun getBlockList(blockListCallback: BlockListCallback) {
         call.enqueue(object : Callback<MutableList<Block>>{
             override fun onFailure(call: Call<MutableList<Block>>, t: Throwable) {
                 blockListCallback.onError(t)
             }

             override fun onResponse(
                 call: Call<MutableList<Block>>,
                 response: Response<MutableList<Block>>
             ) {
                response.body()?.let {
                    blockListCallback.onSuccess(it)
                }
             }

         })
    }
}