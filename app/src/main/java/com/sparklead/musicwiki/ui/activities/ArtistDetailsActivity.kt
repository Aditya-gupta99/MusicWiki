package com.sparklead.musicwiki.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.sparklead.musicwiki.databinding.ActivityArtistDetailsBinding
import com.sparklead.musicwiki.model.artistInfoModel.Tag
import com.sparklead.musicwiki.model.artistTopAlbumModel.Album
import com.sparklead.musicwiki.model.artistTopTrackModel.Track
import com.sparklead.musicwiki.ui.adapter.ArtistAlbumAdapter
import com.sparklead.musicwiki.ui.adapter.ArtistTrackAdapter
import com.sparklead.musicwiki.ui.adapter.TagArtistListAdapter
import com.sparklead.musicwiki.viewmodels.ArtistDetailsViewModel

class ArtistDetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityArtistDetailsBinding
    private val viewModel : ArtistDetailsViewModel by lazy { ViewModelProvider(this)[ArtistDetailsViewModel::class.java]}
    private lateinit var tagList: List<Tag>
    private lateinit var tagAdapter : TagArtistListAdapter
    private lateinit var trackList : List<Track>
    private lateinit var trackAdapter : ArtistTrackAdapter
    private lateinit var albumList : List<Album>
    private lateinit var albumAdapter : ArtistAlbumAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityArtistDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tagList = ArrayList()

        val artist = intent.getStringExtra("artistName").toString()
        binding.artistDetailName.text = artist

        viewModel.artistName.value = artist
        viewModel.getArtistDetail(artist)

        viewModel.artistDetail.observe(this) {
            tagList = it.artist.tags.tag
            binding.artistDetailBody.text = it.artist.bio.summary.substring(0,400)
            binding.playCount.text = viewModel.countViews(it.artist.stats.playcount.toLong())
            binding.followers.text = viewModel.countViews(it.artist.stats.listeners.toLong())
            Glide.with(this).load(it.artist.image[2].text).into(binding.artistImage)
            setDetailsRecycleView()
        }

        viewModel.getArtistTopTrack(artist)

        viewModel.artistTrack.observe(this){
            trackList = it.toptracks.track
            setTrackDetails()
        }

        viewModel.getArtistTopAlbum(artist)

        viewModel.artistAlbum.observe(this){
            albumList  = it.topalbums.album
            setAlbumRecycleView()
        }

    }

    private fun setAlbumRecycleView() {
        albumAdapter = ArtistAlbumAdapter(this,albumList)
        val staggeredGridLayoutManager = StaggeredGridLayoutManager( 1, LinearLayoutManager.HORIZONTAL)
        binding.albumRecyclerView.apply {
            layoutManager = staggeredGridLayoutManager
            adapter =albumAdapter
        }
    }

    private fun setTrackDetails() {
        trackAdapter = ArtistTrackAdapter(this,trackList)
        val staggeredGridLayoutManager = StaggeredGridLayoutManager( 1, LinearLayoutManager.HORIZONTAL)
        binding.tracksRecyclerView.apply {
            layoutManager = staggeredGridLayoutManager
            adapter =trackAdapter
        }
    }

    private fun setDetailsRecycleView() {
        tagAdapter = TagArtistListAdapter(this,tagList)
        val staggeredGridLayoutManager = StaggeredGridLayoutManager( 1, LinearLayoutManager.HORIZONTAL)
        binding.artistRecyclerView.apply {
            layoutManager = staggeredGridLayoutManager
            adapter =tagAdapter
        }


    }
}