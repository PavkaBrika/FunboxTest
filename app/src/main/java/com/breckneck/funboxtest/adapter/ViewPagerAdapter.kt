package com.breckneck.funboxtest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.breckneck.funboxtest.R
import com.breckneck.funboxtest.domain.model.ItemDomain
import java.text.DecimalFormat

class ViewPagerAdapter(
    private val items: List<ItemDomain>,
    private val buyButtonClickListener: OnBuyButtonClickListener
) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    private val decimalFormat = DecimalFormat("#.##")

    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name : TextView = itemView.findViewById(R.id.itemNameTextView)
        val price: TextView = itemView.findViewById(R.id.itemPriceTextView)
        val quantity: TextView = itemView.findViewById(R.id.itemQuantityTextView)
        val currencyString = itemView.resources.getString(R.string.rub)
        val quantityString = itemView.resources.getString(R.string.quant)
        val buyButton: Button = itemView.findViewById(R.id.buyItemButton)
    }

    interface OnBuyButtonClickListener {
        fun onBuyButtonClick(item: ItemDomain)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val item = items[position]
        holder.name.text = item.name
        holder.price.text = "${decimalFormat.format(item.price)} ${holder.currencyString}"
        holder.quantity.text = "${item.quantity.toString()} ${holder.quantityString}"
        holder.buyButton.setOnClickListener {
            buyButtonClickListener.onBuyButtonClick(item = item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}