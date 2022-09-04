package com.aws.day1

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.aws.day1.databinding.ItemDataBinding
import com.bumptech.glide.Glide
import java.util.*

class DataAdapter (var context: Context, var list: MutableList<DataModel>)
    : RecyclerView.Adapter<DataAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.item_data, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemViewData = list[position]
        val url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-SYqF5kXpLxyL-bSTQTP9BwDzv_8IHIaqooehSXFnEMQ9EHHBa4l94gqy-j3ba347LGg&usqp=CAU"
        with(holder.binding) {
            Glide
                .with(context)
                .load(url)
                .centerCrop()
                .into(imageView)
        }

        if (!itemViewData.itemName.isEmpty()){
            holder.binding.tvName.text = itemViewData.itemName



//            when(position){
//                5->{

                    holder.binding.card.setOnClickListener {
                        val random = Random()
                        val color: Int = Color.argb(
                            255,
                            random.nextInt(255),
                            random.nextInt(255),
                            random.nextInt(255)
                        )
                        val color1: Int = Color.argb(
                            255,
                            random.nextInt(255),
                            random.nextInt(255),
                            random.nextInt(255)
                        )
                        holder.binding.card.setBackgroundColor(color)
                        holder.binding.tvName.setTextColor(color1)
                    }
//                }
//            }
        }
//        if (position == 1){
//            holder.itemName.text = "Abcd"
//        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){

        val binding = ItemDataBinding.bind(itemView)
//        var itemName = itemView.findViewById<TextView>(R.id.tv_name)
//        var itemPic = itemView.findViewById<ImageView>(R.id.imageView)
//        var itemCard = itemView.findViewById<ConstraintLayout>(R.id.card)

    }
}