package com.dazai.yukino.network.remoteConfig

import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings

/**
 * Created by Moe Htet on 30,October,2020
 */
object FirebaseRemoteConfig {

    private val remoteConfig = Firebase.remoteConfig

    init {
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 0
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
    }

    // 1 0r 2

    fun setupRemoteConfigWithDefaultValues() {
        val defaultValues: Map<String, Any> = hashMapOf(
            "mainScreenMode" to 1L
        )
        remoteConfig.setDefaultsAsync(defaultValues)
    }

    fun fetchRemoteConfigs() {
        remoteConfig.fetch().addOnCompleteListener {
            if (it.isSuccessful) {
                Log.d("Firebase", "remote config fetch succeed")
                remoteConfig.activate().addOnCompleteListener {
                    Log.d("Activate", "complete")
                }
            } else {
                Log.d("Firebase", "remote config fetch failed")
            }
        }
    }

    fun getMainScreenMode() : Int = remoteConfig.getValue("mainScreenMode").asLong().toInt()

}