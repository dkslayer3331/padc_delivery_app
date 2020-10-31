package com.dazai.yukino.persistance.typeconverters

import androidx.room.TypeConverter
import com.dazai.yukino.data.vos.FoodVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by Moe Htet on 01,November,2020
 */

class FoodVoListTypeConverter {

    @TypeConverter
    fun toString(list : List<FoodVO>) : String{
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(genreStr : String) : List<FoodVO>{
        val foods = object : TypeToken<ArrayList<FoodVO>>() {}.type
        return Gson().fromJson(genreStr, foods)
    }

}