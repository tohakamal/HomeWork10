package com.example.homework10.feature.block_details.view


import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.example.homework10.R
import com.example.homework10.core.BaseActivity

import com.example.homework10.feature.block_details.presenter.BlockDetailsPresenter
import com.example.homework10.feature.block_details.presenter.BlockDetailsPresenterImpl
import com.example.homework10.feature.block_list.model.Block
import kotlinx.android.synthetic.main.activity_block_details.*
import kotlinx.android.synthetic.main.toolbar.*
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_main.*


class BlockDetailsActivity : BaseActivity(),BlockDetailsView{
    override fun setLayoutId(): Int {
        return R.layout.activity_block_details
    }

    override fun setToolbar(): Toolbar {
        toolbar.title = getString(R.string.title)
        return toolbar
    }

    override val isHomeUpButtonEnable: Boolean
        get() = true

    override fun handleProgressBarVisibility(isVisible: Boolean) {
        if (isVisible)
            progress?.visibility=View.VISIBLE
        else
            progress?.visibility=View.GONE
    }

    override fun onBlockDetailsFetchSuccess(block: Block) {
        Glide.with(iv_post)
            .load(block.jetpack_featured_media_url)
            .into(iv_post)
     //   tv_author_value.text=""
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            tv_post_title.text=(Html.fromHtml(block.title.rendered,Html.FROM_HTML_MODE_LEGACY))
        tv_description.text=(Html.fromHtml(block.content.rendered,Html.FROM_HTML_MODE_LEGACY))
        }
        else {
            tv_description.text=(Html.fromHtml(block.content.rendered))
            tv_post_title.text=(Html.fromHtml(block.title.rendered))
        }
    }

    private lateinit var presenter : BlockDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val id=getIntent().getIntExtra("post_id",0)

        presenter = BlockDetailsPresenterImpl(this)

        presenter.getBlockDetails(id)

    }

    override fun onBlockDetailsFetchFailure(errorMessage: String) {
        showToast(errorMessage)

        Logger.e(errorMessage)
    }


}
