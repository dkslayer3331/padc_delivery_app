package com.dazai.yukino.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dazai.yukino.data.vos.FoodTypeVO
import com.dazai.yukino.data.vos.RestaurantVO

/**
 * Created by Moe Htet on 01,November,2020
 */
@Dao
interface RestaurantDao {

    @Query("select * from restaurants")
    fun getAll() : LiveData<List<RestaurantVO>>

    @Query("delete from restaurants")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(list : List<RestaurantVO>)

}