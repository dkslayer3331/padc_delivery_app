package com.dazai.yukino.data.model

/**
 * Created by Moe Htet on 30,October,2020
 */
interface DeliveryModel {
    fun getMainScreenMode(): Int
    fun setupRemoteConfigWithDefaultValues()
    fun fetchRemoteConfigs()
}