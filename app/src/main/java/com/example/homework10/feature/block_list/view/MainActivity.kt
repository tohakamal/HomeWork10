package com.example.homework10.feature.block_list.view


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework10.R
import com.example.homework10.core.BaseActivity
import com.example.homework10.feature.block_details.view.BlockDetailsActivity
import com.example.homework10.feature.block_list.model.Block
import com.example.homework10.feature.block_list.presenter.BlockListPresenter
import com.example.homework10.feature.block_list.presenter.BlockListPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity(),BlockListView {

    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun setToolbar(): Toolbar {
        toolbar.title = getString(R.string.title)
        return toolbar
    }

    override val isHomeUpButtonEnable: Boolean
        get() =   false

    private lateinit var presenter : BlockListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter=BlockListPresenterImpl(this)
        presenter.getBlockList()
    }

    override fun handleProgressBarVisibility(isVisible: Boolean) {
        if (isVisible)
            progress.visibility = View.VISIBLE
        else
            progress.visibility = View.GONE
    }
    override fun onBlockListFetchSuccess(blockList: MutableList<Block>) {
        initBlockAdapter(blockList)
    }

    override fun onBlockListFetchFailure(errorMessage: String) {
        showToast(errorMessage)
    }




    private fun initBlockAdapter(blockList: MutableList<Block>) {

        val adapter = BlockListAdapter(blockList, object : ItemClickListener {

            override fun onItemClicked(position: Int) {
                val intent= Intent(this@MainActivity,BlockDetailsActivity::class.java)
                val id=blockList[position].id
                intent.putExtra("post_id",id)
                startActivity(intent)
            }

        })
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }

}
