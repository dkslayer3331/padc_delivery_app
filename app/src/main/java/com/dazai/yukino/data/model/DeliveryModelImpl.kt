package com.dazai.yukino.data.model

import androidx.lifecycle.LiveData
import com.dazai.yukino.data.vos.FoodTypeVO
import com.dazai.yukino.data.vos.RestaurantVO
import com.dazai.yukino.network.CloudFireStoreImpl
import com.dazai.yukino.network.DeliveryApi
import com.dazai.yukino.network.remoteConfig.FirebaseRemoteConfig

/**
 * Created by Moe Htet on 30,October,2020
 */
object DeliveryModelImpl : DeliveryModel {

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

    }

    override fun getRestaurantDetail(id: String) {

    }

    override fun getFoodTypes(
        onSuccess: (LiveData<List<FoodTypeVO>>) -> Unit,
        onFail: (String) -> Unit
    ) {
        deliveryApi.getFoodTypes(onSuccess = {

        },onFail = {
            onFail(it)
        })
    }
}