package com.dazai.yukino.mvp.views

import com.dazai.yukino.base.BaseView
import com.dazai.yukino.data.vos.FoodVO
import com.dazai.yukino.data.vos.RestaurantVO
import com.dazai.yukino.delegates.FoodTapDelegate

/**
 * Created by Moe Htet on 01,November,2020
 */
interface RestaurantDetailView : BaseView , FoodTapDelegate{
    fun showDetail(restaurantVO: RestaurantVO)
    fun showPopularFoods(list : List<FoodVO>)
    fun showAllFoods(list : List<FoodVO>)
    fun showSuccessAddToCart()
    fun showViewCartBtn()
}