package com.dazai.yukino

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.dazai.yukino.data.vos.CartVO
import com.dazai.yukino.data.vos.FoodVO

/**
 * Created by Moe Htet on 27,October,2020
 */

fun ImageView.loadImage(url: String) = Glide.with(this.context).load(url).into(this)

fun Map<String, Any>?.toFoodVO(): FoodVO {
    return FoodVO(
        id = this?.get("id") as String,
        price = this?.get("price") as Int,
        name = this?.get("name") as String,
        imageUrl = this?.get("image_url") as String,
        ingredients = this?.get("ingredients") as String,
        popular = this?.get("popular") as Boolean,
        ratings = this?.get("ratings") as Int,
        stars = this?.get("stars") as Double
    )
}

fun Map<String, Any>?.toCartVO() : CartVO{
    val temCartItems = mutableListOf<FoodVO>()
    val cartItems = this?.get("cart_items") as Array<Map<String,Any>>?
    cartItems?.let {
        it.forEach { food ->
            temCartItems.add(food.toFoodVO())
        }
    }
    return CartVO(
        cartItems = temCartItems,
        id = this?.get("id") as String,
        quantity = this?.get("quantity") as Int,
        userId = this?.get("user_id") as String
    )
}
