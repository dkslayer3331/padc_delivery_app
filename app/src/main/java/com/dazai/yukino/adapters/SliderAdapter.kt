package com.dazai.yukino.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.dazai.yukino.R
import com.dazai.yukino.data.ui_model.SliderModel
import com.dazai.yukino.loadImage
import com.smarteist.autoimageslider.SliderViewAdapter

/**
 * Created by Moe Htet on 01,November,2020
 */
class SliderAdapter(val data : List<SliderModel>) : SliderViewAdapter<SliderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?): SliderViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.viewholder_custom_image_slider,parent,false)
        return SliderViewHolder(view)
    }

    override fun getCount(): Int = data.size

    override fun onBindViewHolder(viewHolder: SliderViewHolder?, position: Int) {
        viewHolder?.banner?.loadImage(data.get(position).imgUrl)
        viewHolder?.title?.text = data[position].title
        viewHolder?.desc?.text = data[position].desc
    }
}


class  SliderViewHolder(itemView: View?) : SliderViewAdapter.ViewHolder(itemView) {
        val banner : ImageView? = itemView?.findViewById(R.id.ivSlider)
        val title : TextView? = itemView?.findViewById(R.id.tvSliderTitle)
        val desc = itemView?.findViewById<TextView>(R.id.tvSliderDesc)
}