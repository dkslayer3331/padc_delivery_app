package com.dazai.yukino.mvp.views

import androidx.lifecycle.LifecycleOwner
import com.dazai.yukino.base.BaseView
import com.dazai.yukino.data.vos.FoodTypeVO
import com.dazai.yukino.data.vos.RestaurantVO
import com.dazai.yukino.delegates.RestaurantDelegate

/**
 * Created by Moe Htet on 30,October,2020
 */
interface RestaurantView : BaseView , RestaurantDelegate{
    fun showRelevantView(type : Int)
    fun showShowFoodTypes(foodTypes : List<FoodTypeVO>)
    fun showRestaurants(restaurants : List<RestaurantVO>)
}