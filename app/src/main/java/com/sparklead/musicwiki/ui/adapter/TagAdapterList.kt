package com.sparklead.musicwiki.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sparklead.musicwiki.databinding.ItemListTagBinding
import com.sparklead.musicwiki.model.albumDetailModel.Tag
import com.sparklead.musicwiki.ui.activities.GenreDetailsActivity

class TagAdapterList(private val context: Context, private val itemList: List<Tag>) :
    RecyclerView.Adapter<TagAdapterList.TagAdapterViewHolder>() {
    inner class TagAdapterViewHolder(private val binding: ItemListTagBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Tag) {
            binding.item = item
            binding.tvCard.setOnClickListener {
                val intent = Intent(context,GenreDetailsActivity::class.java)
                intent.putExtra("GenreTagName",item.name)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagAdapterViewHolder {
        return TagAdapterViewHolder(
            ItemListTagBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: TagAdapterViewHolder, position: Int) {
        holder.bind(itemList[position])
    }
}