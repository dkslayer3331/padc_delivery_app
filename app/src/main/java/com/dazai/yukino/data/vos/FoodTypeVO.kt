package com.dazai.yukino.data.vos

import com.google.gson.annotations.SerializedName

/**
 * Created by Moe Htet on 01,November,2020
 */
data class FoodTypeVO(
    @SerializedName("id")
    var id : String = "",
    @SerializedName("img_url")
    var imgUrl : String = "",
    @SerializedName("name")
    var name : String = ""
)