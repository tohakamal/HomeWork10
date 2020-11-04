package com.example.homework10.feature.block_list.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_block_details.view.*
import kotlinx.android.synthetic.main.item_block.view.*

class BlockViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    val postImage: AppCompatImageView =itemView.feature_iv
    val postTtile:AppCompatTextView=itemView.tv_title_name
    val authorName:AppCompatTextView=itemView.tv_author
    //val modifiedDate: AppCompatTextView =itemView.tv_updated_date
}