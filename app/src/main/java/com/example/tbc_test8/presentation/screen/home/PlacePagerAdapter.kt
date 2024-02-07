package com.example.tbc_test8.presentation.screen.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tbc_test8.databinding.PlaceItemBinding
import com.example.tbc_test8.presentation.model.PlacePresentation

class PlacePagerAdapter : RecyclerView.Adapter<PlacePagerAdapter.PlaceViewHolder>() {

    private var items: List<PlacePresentation> = listOf()

    inner class PlaceViewHolder(private val binding: PlaceItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) = with(binding) {
            val place = items[position]

            tvPlace.text = place.location
            tvTitle.text = place.title
            tvReactions.text = place.reactionCount.toString()
            tvPrice.text = place.price
            ratingBar.rating = place.rate?.toFloat() ?: 0.0f

            Glide.with(itemView.context).load(place.cover).into(ivPlace)

        }
    }

    fun setItems(data: List<PlacePresentation>) {
        items = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        return PlaceViewHolder(
            PlaceItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        holder.bind(position)
    }
}