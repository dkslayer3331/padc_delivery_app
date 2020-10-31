package com.dazai.yukino.persistance.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dazai.yukino.data.vos.FoodTypeVO
import com.dazai.yukino.data.vos.RestaurantVO
import com.dazai.yukino.persistance.daos.FoodTypesDao
import com.dazai.yukino.persistance.daos.RestaurantDao

/**
 * Created by Moe Htet on 01,November,2020
 */
//todo : entities and daos
@Database(entities = [FoodTypeVO::class,RestaurantVO::class], version = 9, exportSchema = false)
//@TypeConverters()
abstract class DeliveryDb : RoomDatabase() {
    companion object {
        private const val DB_NAME = "PADC_DELIVERY.DB"
        var dbInstance: DeliveryDb? = null

        fun getDBInstance(context: Context): DeliveryDb {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, DeliveryDb::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            val i = dbInstance
            return i!!
        }

    }

    //todo : daos here
    abstract fun foodTypeDao() : FoodTypesDao

    abstract fun restaurantDao() : RestaurantDao

}