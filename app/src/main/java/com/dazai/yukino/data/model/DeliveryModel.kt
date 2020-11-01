package com.dazai.yukino.data.model

import androidx.lifecycle.LiveData
import com.dazai.yukino.data.vos.CartItemWrapper
import com.dazai.yukino.data.vos.FoodTypeVO
import com.dazai.yukino.data.vos.FoodVO
import com.dazai.yukino.data.vos.RestaurantVO
import com.dazai.yukino.network.DeliveryApi

/**
 * Created by Moe Htet on 30,October,2020
 */
interface DeliveryModel {

    var deliveryApi : DeliveryApi

    fun getMainScreenMode(): Int

    fun setupRemoteConfigWithDefaultValues()

    fun fetchRemoteConfigs()

    fun getRestaurants(onSuccess : (LiveData<List<RestaurantVO>>) -> Unit, onFail : (String) -> Unit)

    fun getFoodTypes(onSuccess : (LiveData<List<FoodTypeVO>>) -> Unit, onFail : (String) -> Unit)

    fun getRestaurantById(id : String) : RestaurantVO

    fun addToCart(foodVO: FoodVO,onSuccess: () -> Unit,onFail: (String) -> Unit)

    fun getCartItems(onSuccess : (List<CartItemWrapper>) -> Unit, onFail : (String) -> Unit)

    fun clearCart(ids : List<String>)

    fun onAdd(cartItemWrapper: CartItemWrapper)

    fun onReduce(cartItemWrapper: CartItemWrapper)

}