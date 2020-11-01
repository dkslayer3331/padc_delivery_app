package com.dazai.yukino.data.model

import androidx.lifecycle.LiveData
import com.dazai.yukino.data.vos.FoodTypeVO
import com.dazai.yukino.data.vos.FoodVO
import com.dazai.yukino.data.vos.RestaurantVO
import com.dazai.yukino.network.CloudFireStoreImpl
import com.dazai.yukino.network.DeliveryApi
import com.dazai.yukino.network.remoteConfig.FirebaseRemoteConfig

/**
 * Created by Moe Htet on 30,October,2020
 */
object DeliveryModelImpl : DeliveryModel, BaseModel() {

    private var remoteConfig = FirebaseRemoteConfig

    override var deliveryApi: DeliveryApi = CloudFireStoreImpl

    override fun getMainScreenMode() = remoteConfig.getMainScreenMode()

    override fun setupRemoteConfigWithDefaultValues() {
        remoteConfig.setupRemoteConfigWithDefaultValues()
    }

    override fun fetchRemoteConfigs() {
        remoteConfig.fetchRemoteConfigs()
    }

    override fun getRestaurants(
        onSuccess: (LiveData<List<RestaurantVO>>) -> Unit,
        onFail: (String) -> Unit
    ) {
        deliveryApi.getRestaurants(onSuccess = {
            mDb.restaurantDao().deleteAll()
            mDb.restaurantDao().addAll(it)
            onSuccess(mDb.restaurantDao().getAll())
        },onFail = {
            onFail(it)
        })
    }

    override fun getRestaurantDetail(id: String) {

    }

    override fun getFoodTypes(
        onSuccess: (LiveData<List<FoodTypeVO>>) -> Unit,
        onFail: (String) -> Unit
    ) {
        deliveryApi.getFoodTypes(onSuccess = {
            mDb.foodTypeDao().deleteAll()
            mDb.foodTypeDao().addAll(it)
            onSuccess(mDb.foodTypeDao().getAll())
        },onFail = {
            onFail(it)
        })
    }

    override fun getRestaurantById(id: String): RestaurantVO = mDb.restaurantDao().getRestaurantById(id)

    override fun addToCart(foodVO: FoodVO, onSuccess: () -> Unit, onFail: (String) -> Unit) {
       deliveryApi.addToCart(foodVO,onSuccess,onFail)
    }

}