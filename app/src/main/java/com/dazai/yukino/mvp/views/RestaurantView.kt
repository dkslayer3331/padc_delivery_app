package com.dazai.yukino.mvp.views

import androidx.lifecycle.LifecycleOwner
import com.dazai.yukino.base.BaseView
import com.dazai.yukino.data.vos.FoodTypeVO

/**
 * Created by Moe Htet on 30,October,2020
 */
interface RestaurantView : BaseView{
    fun showRelevantView(type : Int)
    fun showShowFoodTypes(foodTypes : List<FoodTypeVO>)
}