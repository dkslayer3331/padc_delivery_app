package com.dazai.yukino

import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.dazai.yukino.data.vos.CartItemWrapper
import com.dazai.yukino.data.vos.CartVO
import com.dazai.yukino.data.vos.FoodVO
import com.dazai.yukino.data.vos.RestaurantVO

/**
 * Created by Moe Htet on 27,October,2020
 */

fun ImageView.loadImage(url: String) = Glide.with(this.context).load(url).into(this)

fun ImageView.loadAsCircleImage(url: String) = Glide.with(this.context).load(url).circleCrop().into(this)


fun Map<String, Any>?.toFoodVO(): FoodVO {
    return FoodVO(
        id = this?.get("id") as String,
        price = this?.get("price") as Int,
        name = this?.get("name") as String,
        imageUrl = this?.get("image_url") as String,
        ingredients = this?.get("ingredients") as String,
        popular = this?.get("popular") as Boolean,
        ratings = this?.get("ratings") as Int,
        stars = this?.get("stars") as Double,
        type = this?.get("type") as String
    )
}

fun Map<String, Any>?.toCartVO() : CartVO{
    val temCartItems = mutableListOf<CartItemWrapper>()
    val cartItems = this?.get("cart_items") as Array<Map<String,Any>>?
    cartItems?.let {
        it.forEach { food ->
            temCartItems.add(CartItemWrapper(food = (food["food"] as Map<String,Any>?).toFoodVO(),
                quantity = food["quantity"] as Int))
        }
    }
    return CartVO(
        cartItems = temCartItems,
        id = this?.get("id") as String,
        userId = this?.get("user_id") as String
    )
}

fun Map<String, Any>?.toRestaurantVO() : RestaurantVO{
    val tempAvailFoods = mutableListOf<FoodVO>()
    val availFoods = this?.get("avail_foods") as Array<Map<String,Any>>?
    availFoods?.let {
        it.forEach { food ->
            tempAvailFoods.add(food.toFoodVO())
        }
    }
    return RestaurantVO(
       stars = this?.get("stars") as Double,
        id = this?.get("id") as String,
        ratings = this?.get("ratings") as Int,
        name = this?.get("name") as String,
        availFoods = tempAvailFoods,
        location = this?.get("location") as String,
        shopImgUrl = this?.get("shop_img_url") as String
    )
}

fun FoodVO.toMap() : Map<String,Any>{
    return hashMapOf(
        "id" to this.id,
        "price" to this.price,
        "image_url" to this.imageUrl,
        "ratings" to this.ratings,
        "name" to this.name,
        "ingredients" to this.ingredients,
        "stars" to this.stars,
        "popular" to this.popular,
        "type" to this.type
    )
}
