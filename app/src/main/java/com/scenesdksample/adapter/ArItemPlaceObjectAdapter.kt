package com.scenesdksample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.scenesdksample.R
import com.scenesdksample.databinding.ItemArPlaceObjectBinding
import com.scenesdksample.model.PlaceObjectBean

class ArItemPlaceObjectAdapter(
    private val context: Context,
    private val items: MutableList<PlaceObjectBean>, val listener: (PlaceObjectBean) -> Unit) :
    RecyclerView.Adapter<ItemArPlaceObjectViewHolder>() {
    private var selectedPosition=0
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemArPlaceObjectViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemArPlaceObjectBinding.inflate(layoutInflater)
        return ItemArPlaceObjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemArPlaceObjectViewHolder, position: Int) {
        holder.binding.placeObjectBean = items[position]
        if (selectedPosition==position) holder.binding.clMainView.background=AppCompatResources.getDrawable(context,R.drawable.border) else holder.binding.clMainView.background=null
        holder.binding.imageView.setOnClickListener {
            listener(items[position])
            selectedPosition=position
            notifyDataSetChanged()
        }
    }
}

class ItemArPlaceObjectViewHolder(val binding: ItemArPlaceObjectBinding) : RecyclerView.ViewHolder(binding.root)