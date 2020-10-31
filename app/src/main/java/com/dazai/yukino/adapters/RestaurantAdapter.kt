package com.dazai.yukino.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dazai.yukino.R
import com.dazai.yukino.base.BaseRecyclerAdapter
import com.dazai.yukino.data.vos.RestaurantVO
import com.dazai.yukino.views.viewholders.RestaurantViewHolder

/**
 * Created by Moe Htet on 01,November,2020
 */
class RestaurantAdapter : BaseRecyclerAdapter<RestaurantViewHolder, RestaurantVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_restaurant_large_image,parent,false)
        return RestaurantViewHolder(view)
    }
}