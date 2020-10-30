package com.dazai.yukino.data.model

import com.dazai.yukino.network.remoteConfig.FirebaseRemoteConfig

/**
 * Created by Moe Htet on 30,October,2020
 */
object DeliveryModelImpl : DeliveryModel {

    private var remoteConfig = FirebaseRemoteConfig

    override fun getMainScreenMode() = remoteConfig.getMainScreenMode()

    override fun setupRemoteConfigWithDefaultValues() {
        remoteConfig.setupRemoteConfigWithDefaultValues()
    }

    override fun fetchRemoteConfigs() {
        remoteConfig.fetchRemoteConfigs()
    }
}