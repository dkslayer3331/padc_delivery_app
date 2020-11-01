package com.dazai.yukino.network

import com.dazai.yukino.data.vos.*

/**
 * Created by Moe Htet on 27,October,2020
 */
interface DeliveryApi {
    fun getFoodTypes(onSuccess : (List<FoodTypeVO>) -> Unit, onFail : (String) -> Unit)
    fun getRestaurants(onSuccess: (List<RestaurantVO>) -> Unit, onFail: (String) -> Unit)
    fun getCartItems(onSuccess: (List<CartItemWrapper>) -> Unit, onFail: (String) -> Unit)
    fun addToCart(foodVO: FoodVO,onSuccess: () -> Unit, onFail: (String) -> Unit)
    fun clearCart(ids : List<String>)
}