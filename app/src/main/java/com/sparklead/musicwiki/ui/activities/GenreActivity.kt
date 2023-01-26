package com.sparklead.musicwiki.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sparklead.musicwiki.R
import com.sparklead.musicwiki.databinding.ActivityGenreBinding
import com.sparklead.musicwiki.model.tagDataClass.Tag
import com.sparklead.musicwiki.ui.adapter.GenreListAdapter
import com.sparklead.musicwiki.viewmodels.GenreViewModel

class GenreActivity : BaseActivity() {

    private lateinit var binding : ActivityGenreBinding
    private lateinit var genreList : List<Tag>
    private val viewModel:GenreViewModel by lazy { ViewModelProvider(this)[GenreViewModel::class.java] }
    private lateinit var genreAdapter :GenreListAdapter
    private var expend : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showLoadingDialog()

        binding.lifecycleOwner = this


        viewModel.getGenreTag()
        viewModel._tagList.observe(this){
            if(it == "true"){
                genreList = viewModel.tagList
                hideLoading()
                setAdapter()
            }
        }

        binding.ivExpend.setOnClickListener {
            if(expend){
                expend = false
                binding.ivExpend.setImageDrawable(resources.getDrawable(R.drawable.down_arrow))
                genreAdapter = GenreListAdapter(this ,genreList.subList(0,10))
                val staggeredGridLayoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
                binding.genreListRecycleView.apply {
                    layoutManager = staggeredGridLayoutManager
                    adapter =genreAdapter
                }
            }else{
                expend = true
                binding.ivExpend.setImageDrawable(resources.getDrawable(R.drawable.up_arrow))
                genreAdapter = GenreListAdapter(this ,genreList)
                val staggeredGridLayoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
                binding.genreListRecycleView.apply {
                    layoutManager = staggeredGridLayoutManager
                    adapter =genreAdapter
                }
            }
        }

    }

    private fun setAdapter() {
        Log.d("tagList", genreList.toString())
        genreAdapter = GenreListAdapter(this,genreList.subList(0,10))
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
        binding.genreListRecycleView.apply {
            layoutManager = staggeredGridLayoutManager
            adapter =genreAdapter
        }
    }
}