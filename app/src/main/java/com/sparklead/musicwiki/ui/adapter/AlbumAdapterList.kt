package com.sparklead.musicwiki.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sparklead.musicwiki.databinding.ItemListAlbumBinding
import com.sparklead.musicwiki.model.albumModel.Album

class AlbumAdapterList(private val context : Context,private val itemList : List<Album>) : RecyclerView.Adapter<AlbumAdapterList.AlbumViewHolder>(){

    inner class AlbumViewHolder(private val binding : ItemListAlbumBinding ) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : Album){
            binding.item = item
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder(
            ItemListAlbumBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

}