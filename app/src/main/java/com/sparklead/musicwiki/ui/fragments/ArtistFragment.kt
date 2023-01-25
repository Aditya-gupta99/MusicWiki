package com.sparklead.musicwiki.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sparklead.musicwiki.R
import com.sparklead.musicwiki.databinding.FragmentArtistBinding
import com.sparklead.musicwiki.model.artistModel.Artist
import com.sparklead.musicwiki.ui.adapter.AlbumAdapterList
import com.sparklead.musicwiki.ui.adapter.ArtistAdapterList
import com.sparklead.musicwiki.viewmodels.GenreDetailsViewModel

class ArtistFragment : Fragment() {

    private lateinit var binding : FragmentArtistBinding
    private lateinit var viewModel : GenreDetailsViewModel
    private lateinit var artistList : List<Artist>
    private lateinit var adapter : ArtistAdapterList

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentArtistBinding.inflate(inflater,container,false)
        viewModel = activity?.let { ViewModelProvider(it)[GenreDetailsViewModel::class.java] }!!

        artistList = ArrayList()

        val tagName = viewModel.tagName.value.toString()
        viewModel.getArtist(tagName)
        viewModel.topArtist.observe(requireActivity()){
            artistList = it.topartists.artist
            setRecycleView()
        }
        return binding.root
    }

    private fun setRecycleView() {
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = ArtistAdapterList(requireActivity(),artistList)
        binding.artistRecyclerView.adapter = adapter
    }
}