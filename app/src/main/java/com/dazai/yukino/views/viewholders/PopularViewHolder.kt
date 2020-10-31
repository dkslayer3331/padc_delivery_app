package com.dazai.yukino.views.viewholders

import android.view.View
import com.dazai.yukino.base.BaseViewHolder
import com.dazai.yukino.data.vos.FoodVO
import com.dazai.yukino.loadImage
import kotlinx.android.synthetic.main.viewholder_popular_item.view.*

/**
 * Created by Moe Htet on 01,November,2020
 */
class PopularViewHolder(itemView: View) : BaseViewHolder<FoodVO>(itemView) {
    override fun bindData(data: FoodVO) {
        itemView.ivPopualarFood.loadImage(data.imageUrl)
        itemView.tvPopularFood.text = data.name
        itemView.tvPopularFoodPrice.text = "$${data.price}"
    }
}