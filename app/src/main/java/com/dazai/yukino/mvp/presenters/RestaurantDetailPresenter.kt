package com.dazai.yukino.mvp.presenters

import com.dazai.yukino.base.BasePresenter
import com.dazai.yukino.data.vos.FoodVO
import com.dazai.yukino.mvp.views.RestaurantDetailView

/**
 * Created by Moe Htet on 01,November,2020
 */
interface RestaurantDetailPresenter : BasePresenter<RestaurantDetailView> {
    fun onUiReady(id : String)
    fun onTapAddToCart(foodVO: FoodVO)
}