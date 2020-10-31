package com.dazai.yukino.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Moe Htet on 01,November,2020
 */
@Entity(tableName = "foodTypes")
data class FoodTypeVO(
    @PrimaryKey
    @SerializedName("id")
    var id : String = "",
    @SerializedName("img_url")
    var imgUrl : String = "",
    @SerializedName("name")
    var name : String = ""
)