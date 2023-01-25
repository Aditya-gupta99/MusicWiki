package com.sparklead.musicwiki.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sparklead.musicwiki.R
import com.sparklead.musicwiki.databinding.FragmentAlbumBinding
import com.sparklead.musicwiki.model.albumModel.Album
import com.sparklead.musicwiki.ui.adapter.AlbumAdapterList
import com.sparklead.musicwiki.ui.adapter.GenreListAdapter
import com.sparklead.musicwiki.viewmodels.GenreDetailsViewModel


class AlbumFragment : Fragment() {

    private lateinit var binding : FragmentAlbumBinding
    private lateinit var viewModel: GenreDetailsViewModel
    private lateinit var albumList: List<Album>
    private lateinit var albumAdapter: AlbumAdapterList

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentAlbumBinding.inflate(inflater,container,false)

        viewModel = activity?.let { ViewModelProvider(it)[GenreDetailsViewModel::class.java] }!!
        albumList = ArrayList()


        val tagName = viewModel.tagName.value.toString()
        viewModel.getAlbum(tagName)

        viewModel.topAlbum.observe(requireActivity()){
            albumList = it.albums.album
            setRecycleView()
//            albumAdapter = AlbumAdapterList(requireContext(),albumList)
//            albumAdapter.notifyDataSetChanged()
        }

        return  binding.root
    }

    private fun setRecycleView() {
        binding.albumRecyclerView.layoutManager =LinearLayoutManager(activity)
        Log.e("newDetails",albumList.toString())
        albumAdapter =AlbumAdapterList(requireActivity(),albumList)
        binding.albumRecyclerView.adapter = albumAdapter
    }

}