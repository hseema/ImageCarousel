package com.example.imagecarousel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imagecarousel.databinding.ListItemBinding

class ListItemAdapter: RecyclerView.Adapter<MyViewHolder>() {
    private var itemList:List<Item> = listOf()

    fun setList(items:List<Item>){
        itemList = items
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = ListItemBinding.inflate(
            layoutInflater,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}


class MyViewHolder(private val binding:ListItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(item:Item){
        binding.titleTextView.text = item.title
        binding.imageView.setImageResource(item.icon)
    }

}