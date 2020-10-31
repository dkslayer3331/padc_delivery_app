package com.dazai.yukino.data.model

import androidx.lifecycle.LiveData
import com.dazai.yukino.data.vos.FoodTypeVO
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

    fun getRestaurantDetail(id : String)

    fun getFoodTypes(onSuccess : (LiveData<List<FoodTypeVO>>) -> Unit, onFail : (String) -> Unit)

    fun getRestaurantById(id : String) : RestaurantVO

}