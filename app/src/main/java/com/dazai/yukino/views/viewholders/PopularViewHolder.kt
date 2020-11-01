package com.dazai.yukino.views.viewholders

import android.view.View
import com.dazai.yukino.base.BaseViewHolder
import com.dazai.yukino.data.vos.FoodVO
import com.dazai.yukino.delegates.FoodTapDelegate
import com.dazai.yukino.loadImage
import kotlinx.android.synthetic.main.viewholder_popular_item.view.*

/**
 * Created by Moe Htet on 01,November,2020
 */
class PopularViewHolder(itemView: View, val foodTapDelegate: FoodTapDelegate) : BaseViewHolder<FoodVO>(itemView) {

    init {
        itemView.setOnClickListener {
            mData?.let {
                foodTapDelegate.onTapAddToCart(it)
            }
        }
    }

    override fun bindData(data: FoodVO) {
        mData = data
        itemView.ivPopualarFood.loadImage(data.imageUrl)
        itemView.tvPopularFood.text = data.name
        itemView.tvPopularFoodPrice.text = "$${data.price}"
    }
}