package com.dazai.yukino.network

import com.dazai.yukino.data.vos.CartVO
import com.dazai.yukino.data.vos.FoodVO
import com.dazai.yukino.data.vos.RestaurantVO

/**
 * Created by Moe Htet on 27,October,2020
 */
interface DeliveryApi {
    fun getRestaurants(onSuccess: (List<RestaurantVO>)-> Unit,onFail : (String)-> Unit)
    fun getFoods(onSuccess: (List<FoodVO>)-> Unit,onFail : (String)-> Unit)
    fun getCartItems(userId : String,onSuccess: (CartVO)-> Unit,onFail : (String)-> Unit)
}