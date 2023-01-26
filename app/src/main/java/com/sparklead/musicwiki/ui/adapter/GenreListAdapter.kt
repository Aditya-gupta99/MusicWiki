package com.sparklead.musicwiki.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sparklead.musicwiki.R
import com.sparklead.musicwiki.databinding.ItemTagBinding
import com.sparklead.musicwiki.model.tagDataClass.Tag
import com.sparklead.musicwiki.ui.activities.GenreDetailsActivity

class GenreListAdapter(private val context : Context, private val itemList: List<Tag>) :
    RecyclerView.Adapter<GenreListAdapter.GenreViewHolder>() {

    inner class GenreViewHolder(private val binding: ItemTagBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Tag) {
            binding.item = item
            binding.cvTag.setOnClickListener {
                val intent  = Intent(context,GenreDetailsActivity::class.java)
                intent.putExtra("GenreTagName",item.name)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        return GenreViewHolder(
            ItemTagBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

}