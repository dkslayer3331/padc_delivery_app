package com.dazai.yukino.mvp.views

import com.dazai.yukino.base.BaseView
import com.dazai.yukino.data.vos.FoodVO
import com.dazai.yukino.data.vos.RestaurantVO

/**
 * Created by Moe Htet on 01,November,2020
 */
interface RestaurantDetailView : BaseView {
    fun showDetail(restaurantVO: RestaurantVO)
    fun showPopularFoods(list : List<FoodVO>)
    fun showAllFoods(list : List<FoodVO>)
}