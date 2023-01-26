package com.sparklead.musicwiki.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sparklead.musicwiki.databinding.ActivityGenreBinding
import com.sparklead.musicwiki.model.tagDataClass.Tag
import com.sparklead.musicwiki.ui.adapter.GenreListAdapter
import com.sparklead.musicwiki.viewmodels.GenreViewModel

class GenreActivity : AppCompatActivity() {

    private lateinit var binding : ActivityGenreBinding
    private lateinit var genreList : List<Tag>
    private val viewModel:GenreViewModel by lazy { ViewModelProvider(this)[GenreViewModel::class.java] }
    private lateinit var genreAdapter :GenreListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenreBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.lifecycleOwner = this

//        supportActionBar!!.hide()


        viewModel.getGenreTag()
        viewModel._tagList.observe(this){
            if(it == "true"){
                genreList = viewModel.tagList
                setAdapter()
            }
        }
    }

    private fun setAdapter() {
        Log.d("tagList", genreList.toString())
        genreAdapter = GenreListAdapter(this,genreList)
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
        binding.genreListRecycleView.apply {
            layoutManager = staggeredGridLayoutManager
            adapter =genreAdapter
        }
    }
}