package com.dazai.yukino.delegates

import com.dazai.yukino.data.vos.FoodVO

/**
 * Created by Moe Htet on 01,November,2020
 */
interface FoodTapDelegate {
    fun onTapAddToCart(foodVO: FoodVO)
}