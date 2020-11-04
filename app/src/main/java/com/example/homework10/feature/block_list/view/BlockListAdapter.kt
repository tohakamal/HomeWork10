package com.example.homework10.feature.block_list.view

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework10.R
import com.example.homework10.feature.block_list.model.Block

class BlockListAdapter(

    private val blockList:MutableList<Block>,
    private val itemClickListener:ItemClickListener) :
    RecyclerView.Adapter<BlockViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlockViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_block, parent, false)
        return BlockViewHolder(view)
    }

    override fun getItemCount(): Int {
       return blockList.size
    }

    override fun onBindViewHolder(holder: BlockViewHolder, position: Int) {
        val block=blockList[position]
        holder.authorName.text="Hasan Abdullah"
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            holder.postTtile.text=(Html.fromHtml(block.title.rendered,Html.FROM_HTML_MODE_LEGACY))
        }
        else {
            holder.postTtile.text=(Html.fromHtml(block.title.rendered))
        }
        //holder.postTtile.text=post.title.rendered
        // holder.modifiedDate.text=post.modifiedDate
        Glide.with(holder.postImage)
            .load(block.jetpack_featured_media_url)
            .into(holder.postImage)
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClicked(position)
        }
    }

}