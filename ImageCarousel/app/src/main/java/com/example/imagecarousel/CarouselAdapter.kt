package com.example.imagecarousel


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imagecarousel.databinding.CarouselItemBinding


class CarouselAdapter() : RecyclerView.Adapter<ItemViewHolder>() {

    private var items: List<Item> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder
        {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding : CarouselItemBinding = CarouselItemBinding.inflate(
                layoutInflater,
                parent,
                false
            )
            return ItemViewHolder(binding)

        }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    fun setItems(newItems: List<Item>) {
        items = newItems
        notifyDataSetChanged()
    }
}

class ItemViewHolder(val binding:CarouselItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Item) {
        binding.listItemText.text = "${item.title}"
        binding.listItemIcon.setImageResource(item.icon)
    }
}