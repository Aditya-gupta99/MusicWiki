package com.sparklead.musicwiki.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.sparklead.musicwiki.databinding.ActivityAlbumDetailsBinding
import com.sparklead.musicwiki.model.albumDetailModel.Tag
import com.sparklead.musicwiki.ui.adapter.AlbumAdapterList
import com.sparklead.musicwiki.ui.adapter.TagAdapterList
import com.sparklead.musicwiki.viewmodels.AlbumDetailsViewModel

class AlbumDetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAlbumDetailsBinding
    private val viewModel : AlbumDetailsViewModel by lazy { ViewModelProvider(this)[AlbumDetailsViewModel::class.java]}
    private lateinit var tagList : List<Tag>
    private lateinit var tagAdapter :TagAdapterList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAlbumDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val album = intent.getStringExtra("albumName").toString()
        val artist = intent.getStringExtra("artistName").toString()


        viewModel.getAlbumDetail(artist, album)
        viewModel.albumDetail.observe(this) {

            tagList = it.album.tags.tag
            setRecycleView()
            binding.albumDetailName.text = it.album.name
            binding.albumArtistName.text = it.album.artist
            Glide.with(this).load(it.album.image[2].text).into(binding.albumDetailImage)
            binding.albumDetailBody.text = it.album.wiki.summary
        }



    }

    private fun setRecycleView() {
        tagAdapter = TagAdapterList(this,tagList)
        val staggeredGridLayoutManager = StaggeredGridLayoutManager( 1,LinearLayoutManager.HORIZONTAL)
        binding.tagRecyclerView.apply {
            layoutManager = staggeredGridLayoutManager
            adapter =tagAdapter
        }
    }
}