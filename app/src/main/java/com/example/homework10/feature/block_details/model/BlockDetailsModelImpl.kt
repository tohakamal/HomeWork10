package com.example.homework10.feature.block_details.model

import com.example.homework10.feature.block_list.model.Block
import com.example.homework10.network.BlockApiInterface
import com.example.homework10.network.RetrofitClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class BlockDetailsModelImpl : BlockDetailsModel {


    val blockDetailsApiInterface=RetrofitClient.getClient().create(BlockApiInterface::class.java)

    override fun getBlockDetails(id: Int, blockDetailsCallback: BlockDetailsCallback) {
        val call = blockDetailsApiInterface.getBlockDetails(id)
        call.enqueue(object :Callback<Block>{
            override fun onFailure(call: Call<Block>, t: Throwable) {
                blockDetailsCallback.onError(t)
            }

            override fun onResponse(call: Call<Block>, response: Response<Block>) {
                response.body()?.let {
                    blockDetailsCallback.onSuccess(it)
                }
            }

        })

    }


}


