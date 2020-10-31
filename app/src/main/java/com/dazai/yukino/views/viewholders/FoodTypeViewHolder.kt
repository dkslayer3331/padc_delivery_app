package com.dazai.yukino.views.viewholders

import android.view.View
import com.dazai.yukino.base.BaseViewHolder
import com.dazai.yukino.data.vos.FoodTypeVO
import com.dazai.yukino.loadImage
import kotlinx.android.synthetic.main.viweholder_food_type.view.*

/**
 * Created by Moe Htet on 01,November,2020
 */
class FoodTypeViewHolder(itemView: View) : BaseViewHolder<FoodTypeVO>(itemView) {
    override fun bindData(data: FoodTypeVO) {
        itemView.ivFoodType.loadImage(data.imgUrl)
        itemView.tvFoodTypeLabel.text = data.name
    }
}