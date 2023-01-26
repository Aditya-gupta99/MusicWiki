package com.sparklead.musicwiki.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sparklead.musicwiki.databinding.ItemArtistAlbumBinding
import com.sparklead.musicwiki.model.artistTopAlbumModel.Album
import com.sparklead.musicwiki.ui.activities.AlbumDetailsActivity

class ArtistAlbumAdapter(private val context: Context, private val itemList: List<Album>) :
    RecyclerView.Adapter<ArtistAlbumAdapter.AlbumViewModel>() {
    inner class AlbumViewModel(private val binding: ItemArtistAlbumBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Album) {
            binding.item = item
            binding.cvTag.setOnClickListener {
                val intent = Intent(context, AlbumDetailsActivity::class.java)
                intent.putExtra("albumName", item.name)
                intent.putExtra("artistName",item.artist.name)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewModel {
        return AlbumViewModel(
            ItemArtistAlbumBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: AlbumViewModel, position: Int) {
        holder.bind(itemList[position])
    }
}