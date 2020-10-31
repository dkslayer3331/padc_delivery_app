package com.dazai.yukino.views.viewholders

import android.view.View
import com.dazai.yukino.base.BaseViewHolder
import com.dazai.yukino.data.vos.FoodVO
import kotlinx.android.synthetic.main.viewholder_normal_food_item.view.*

/**
 * Created by Moe Htet on 01,November,2020
 */
class NormalFoodViewHolder(itemView: View) : BaseViewHolder<FoodVO>(itemView) {
    override fun bindData(data: FoodVO) {
        itemView.tvGeneralFoodName.text = data.name
        itemView.tvGeneralFoodPrice.text = "$${data.price}"
        itemView.tvGeneralFoodIngredients.text = data.ingredients
        itemView.rbIsPopular.visibility = if (data.popular) View.VISIBLE else View.GONE
        itemView.tvIsPopular.visibility = if (data.popular) View.VISIBLE else View.GONE
    }
}