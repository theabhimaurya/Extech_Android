package com.aws.day1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter (var context: Context, var list: MutableList<DataModel>)
    : RecyclerView.Adapter<DataAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.item_data, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemViewData = list[position]

        if (!itemViewData.itemName.isEmpty()){
            holder.itemName.text = itemViewData.itemName
        }
//        if (position == 1){
//            holder.itemName.text = "Abcd"
//        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        var itemName = itemView.findViewById<TextView>(R.id.tv_name)
    }
}