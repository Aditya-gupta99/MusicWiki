package com.sparklead.musicwiki.ui.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sparklead.musicwiki.R
import com.sparklead.musicwiki.databinding.ItemListArtistTagBinding
import com.sparklead.musicwiki.model.artistInfoModel.Tag
import com.sparklead.musicwiki.ui.activities.GenreDetailsActivity


class TagArtistListAdapter(private val context: Context, private val itemList: List<Tag>) :
    RecyclerView.Adapter<TagArtistListAdapter.TagAdapterViewHolder>() {
    inner class TagAdapterViewHolder(private val binding: ItemListArtistTagBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Tag) {
            binding.item = item
            binding.tvCard.setOnClickListener {
                val intent = Intent(context, GenreDetailsActivity::class.java)
                intent.putExtra("GenreTagName",item.name)
                context.startActivity(intent)
                (context as Activity).overridePendingTransition(
                    R.anim.slide_in_right,
                    R.anim.slide_out_left
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagAdapterViewHolder {
        return TagAdapterViewHolder(
            ItemListArtistTagBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TagAdapterViewHolder, position: Int) {
        holder.bind(itemList[position])
    }


    override fun getItemCount(): Int {
        return itemList.size
    }


}