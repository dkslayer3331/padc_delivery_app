package com.dazai.yukino.app

import android.app.Application
import com.dazai.yukino.data.model.DeliveryModelImpl
import com.dazai.yukino.network.CloudFireStoreImpl

/**
 * Created by Moe Htet on 27,October,2020
 */
class DeliveryApp : Application() {
    override fun onCreate() {
        super.onCreate()

        DeliveryModelImpl.initDb(this)

    }

}