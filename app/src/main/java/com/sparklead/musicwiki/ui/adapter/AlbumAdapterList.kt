package com.sparklead.musicwiki.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sparklead.musicwiki.databinding.ItemListAlbumBinding
import com.sparklead.musicwiki.model.albumDetailModel.Tag
import com.sparklead.musicwiki.model.albumModel.Album
import com.sparklead.musicwiki.ui.activities.AlbumDetailsActivity

class AlbumAdapterList(private val context: Context, private val itemList: List<Album>) : RecyclerView.Adapter<AlbumAdapterList.AlbumViewHolder>(){

    inner class AlbumViewHolder(private val binding : ItemListAlbumBinding ) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : Album){
            binding.item = item
            binding.cvAlbumList.setOnClickListener {
                val intent = Intent(context,AlbumDetailsActivity::class.java)
                intent.putExtra("albumName", item.name)
                intent.putExtra("artistName",item.artist.name)
                context.startActivity(intent)
            }
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