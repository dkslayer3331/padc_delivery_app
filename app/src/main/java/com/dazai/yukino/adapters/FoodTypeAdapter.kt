package com.dazai.yukino.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dazai.yukino.R
import com.dazai.yukino.base.BaseRecyclerAdapter
import com.dazai.yukino.data.vos.FoodTypeVO
import com.dazai.yukino.views.viewholders.FoodTypeViewHolder

/**
 * Created by Moe Htet on 01,November,2020
 */
class FoodTypeAdapter : BaseRecyclerAdapter<FoodTypeViewHolder, FoodTypeVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodTypeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viweholder_food_type,parent,false)
        return FoodTypeViewHolder(view)
    }
}