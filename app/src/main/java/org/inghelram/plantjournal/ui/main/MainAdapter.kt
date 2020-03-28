package org.inghelram.plantjournal.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.inghelram.plantjournal.R
import org.inghelram.plantjournal.data.OverviewItem
import org.inghelram.plantjournal.databinding.ItemMainBinding

class MainAdapter(myData: List<OverviewItem>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private var data: List<OverviewItem> = myData

    fun replaceData(myData: List<OverviewItem>?) {
        myData?.let{
            if (!data.containsAll(myData)) {
                data = myData
                notifyDataSetChanged()
            }
        }
    }

    class ViewHolder(val itemMainBinding: ItemMainBinding) : RecyclerView.ViewHolder(itemMainBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemMainBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_main, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val overviewItem = data[position]
        holder.itemMainBinding.overviewItem = overviewItem
    }
}