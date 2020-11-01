package com.dazai.yukino.data.model

import android.content.Context
import com.dazai.yukino.persistance.database.DeliveryDb

/**
 * Created by Moe Htet on 01,November,2020
 */

abstract class BaseModel{

    lateinit var mDb: DeliveryDb

    fun initDb(context: Context){
        mDb = DeliveryDb.getDBInstance(context)
    }

}