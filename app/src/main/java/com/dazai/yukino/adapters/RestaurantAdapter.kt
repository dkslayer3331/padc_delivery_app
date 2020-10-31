package com.dazai.yukino.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dazai.yukino.R
import com.dazai.yukino.base.BaseRecyclerAdapter
import com.dazai.yukino.base.BaseViewHolder
import com.dazai.yukino.data.vos.RestaurantVO
import com.dazai.yukino.delegates.RestaurantDelegate
import com.dazai.yukino.views.viewholders.RestaurantViewHolder
import com.dazai.yukino.views.viewholders.RestaurantViewHolderTwo

/**
 * Created by Moe Htet on 01,November,2020
 */
class RestaurantAdapter(var type : Int = 1,var delegate : RestaurantDelegate) : BaseRecyclerAdapter<BaseViewHolder<RestaurantVO>, RestaurantVO>() {

    fun setViewType(type: Int){
        this.type = type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<RestaurantVO> {
        when (type) {
            1 -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_restaurant_large_image,parent,false)
                return RestaurantViewHolder(view,delegate)
            }
            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_restaurant_small_image,parent,false)
                return RestaurantViewHolderTwo(view,delegate)
            }
        }
    }
}