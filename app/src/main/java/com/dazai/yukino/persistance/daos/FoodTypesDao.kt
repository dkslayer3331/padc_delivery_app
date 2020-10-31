package com.dazai.yukino.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dazai.yukino.data.vos.FoodTypeVO

/**
 * Created by Moe Htet on 01,November,2020
 */
@Dao
interface FoodTypesDao{

    @Query("select * from foodTypes")
    fun getAll() : LiveData<List<FoodTypeVO>>

    @Query("delete from foodTypes")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(list : List<FoodTypeVO>)

}