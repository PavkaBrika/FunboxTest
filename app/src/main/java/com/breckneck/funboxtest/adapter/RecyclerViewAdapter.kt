package com.breckneck.funboxtest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.breckneck.funboxtest.R
import com.breckneck.funboxtest.domain.model.ItemDomain

class RecyclerViewAdapter(
    private val items: List<ItemDomain>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name : TextView = itemView.findViewById(R.id.itemNameRecyclerTextView)
        val quantity : TextView = itemView.findViewById(R.id.itemQuantityRecyclerTextView)
        val quantityString = itemView.resources.getString(R.string.quant)
    }

    interface OnItemClickListener {
        fun onItemClick(item: ItemDomain, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val item = items[position]
        holder.name.text = item.name
        holder.quantity.text = "${item.quantity.toString()} ${holder.quantityString}"

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(item = item, position = position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}