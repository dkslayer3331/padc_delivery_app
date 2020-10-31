package com.dazai.yukino.views.viewholders

import android.view.View
import com.dazai.yukino.base.BaseViewHolder
import com.dazai.yukino.data.vos.RestaurantVO
import com.dazai.yukino.loadImage
import kotlinx.android.synthetic.main.viewholder_restaurant_small_image.view.*

/**
 * Created by Moe Htet on 01,November,2020
 */
class RestaurantViewHolderTwo(itemView: View) : BaseViewHolder<RestaurantVO>(itemView) {
    override fun bindData(data: RestaurantVO) {
        itemView.tvRestaurantName.text = data.name
        itemView.tvShopLocation.text = data.location
        itemView.tvRestaurantAvgScore.text = "${data.stars}"
        itemView.ivRestaurantBanner.loadImage(data.shopImgUrl)
        itemView.tvRestaurantRating.text = "(${data.ratings} ratings)"
    }
}