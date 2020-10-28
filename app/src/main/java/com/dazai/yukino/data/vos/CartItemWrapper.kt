package com.dazai.yukino.data.vos

import com.google.gson.annotations.SerializedName

/**
 * Created by Moe Htet on 29,October,2020
 */
data class CartItemWrapper(
    @SerializedName("food")
    var food : FoodVO = FoodVO(),
    @SerializedName("quantity")
    var quantity : Int = 0
)