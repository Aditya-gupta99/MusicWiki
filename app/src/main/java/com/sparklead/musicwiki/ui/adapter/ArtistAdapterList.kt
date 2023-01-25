package com.sparklead.musicwiki.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sparklead.musicwiki.databinding.ItemListAlbumBinding
import com.sparklead.musicwiki.databinding.ItemListArtistBinding
import com.sparklead.musicwiki.model.albumModel.Album
import com.sparklead.musicwiki.model.artistModel.Artist

class ArtistAdapterList(private val context : Context, private val itemList : List<Artist>) : RecyclerView.Adapter<ArtistAdapterList.ArtistViewHolder>(){
    inner class ArtistViewHolder(private val binding : ItemListArtistBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item : Artist){
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        return ArtistViewHolder(
            ItemListArtistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(itemList[position])
    }
}