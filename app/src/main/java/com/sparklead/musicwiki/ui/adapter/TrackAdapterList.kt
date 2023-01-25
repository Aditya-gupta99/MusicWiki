package com.sparklead.musicwiki.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sparklead.musicwiki.databinding.ItemListTrackBinding
import com.sparklead.musicwiki.model.trackModel.Track

class TrackAdapterList(private val context: Context, private val itemList: List<Track>) :
    RecyclerView.Adapter<TrackAdapterList.TrackViewHolder>() {
    inner class TrackViewHolder(private val binding: ItemListTrackBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Track) {
            binding.item = item
            Glide.with(context).load(itemList[position].image[0].text).into(binding.ivTrack)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        return TrackViewHolder(
            ItemListTrackBinding.inflate(
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