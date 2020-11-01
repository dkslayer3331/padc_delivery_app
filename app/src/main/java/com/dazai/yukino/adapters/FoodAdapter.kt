package com.dazai.yukino.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dazai.yukino.R
import com.dazai.yukino.base.BaseRecyclerAdapter
import com.dazai.yukino.base.BaseViewHolder
import com.dazai.yukino.data.vos.FoodVO
import com.dazai.yukino.delegates.FoodTapDelegate
import com.dazai.yukino.views.viewholders.NormalFoodViewHolder
import com.dazai.yukino.views.viewholders.PopularViewHolder

/**
 * Created by Moe Htet on 01,November,2020
 */
class FoodAdapter(private val isPopular: Boolean,val foodTapDelegate: FoodTapDelegate) : BaseRecyclerAdapter<BaseViewHolder<FoodVO>, FoodVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<FoodVO> {
        if(isPopular){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_popular_item,parent,false)
            return PopularViewHolder(view,foodTapDelegate)
        }
        else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_normal_food_item,parent,false)
            return NormalFoodViewHolder(view, foodTapDelegate)
        }
    }
}