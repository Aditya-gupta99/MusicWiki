package com.sparklead.musicwiki.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sparklead.musicwiki.databinding.ItemArtistTrackBinding
import com.sparklead.musicwiki.model.artistTopTrackModel.Track

class ArtistTrackAdapter(private val context: Context, private val itemList: List<Track>) :
    RecyclerView.Adapter<ArtistTrackAdapter.TrackViewHolder>() {
    inner class TrackViewHolder(private val binding: ItemArtistTrackBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Track) {
            binding.item = item
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        return TrackViewHolder(
            ItemArtistTrackBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.bind(itemList[position])
    }
}