package com.sparklead.musicwiki.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sparklead.musicwiki.databinding.FragmentTrackBinding
import com.sparklead.musicwiki.model.trackModel.Track
import com.sparklead.musicwiki.ui.adapter.ArtistAdapterList
import com.sparklead.musicwiki.ui.adapter.TrackAdapterList
import com.sparklead.musicwiki.viewmodels.GenreDetailsViewModel

class TrackFragment : Fragment() {

    private lateinit var binding : FragmentTrackBinding
    private lateinit var viewModel : GenreDetailsViewModel
    private lateinit var trackList : List<Track>
    private lateinit var adapter : TrackAdapterList

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTrackBinding.inflate(inflater,container,false)
        viewModel = activity?.let { ViewModelProvider(it)[GenreDetailsViewModel::class.java] }!!

        trackList = ArrayList()

        val tagName = viewModel.tagName.value.toString()
        viewModel.getTrack(tagName)
        viewModel.topTracks.observe(requireActivity()){
            trackList = it.tracks.track
            setRecycleView()
        }

        return binding.root
    }

    private fun setRecycleView() {
        binding.trackRecyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = TrackAdapterList(requireActivity(),trackList)
        binding.trackRecyclerView.adapter = adapter
    }

}