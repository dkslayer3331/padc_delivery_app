package com.dazai.yukino.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dazai.yukino.R
import com.dazai.yukino.base.BaseRecyclerAdapter
import com.dazai.yukino.base.BaseViewHolder
import com.dazai.yukino.data.vos.FoodTypeVO
import com.dazai.yukino.views.viewholders.FoodTypeViewHolder
import com.dazai.yukino.views.viewholders.FoodTypeViewHolderTwo

/**
 * Created by Moe Htet on 01,November,2020
 */
class FoodTypeAdapter(var type: Int = 1) :
    BaseRecyclerAdapter<BaseViewHolder<FoodTypeVO>, FoodTypeVO>() {

    fun setViewType(type: Int) {
        this.type = type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<FoodTypeVO> {
        if (type == 1) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.viweholder_food_type, parent, false)
            return FoodTypeViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.viewholder_food_type_image, parent, false)
            return FoodTypeViewHolderTwo(view)
        }
    }
}