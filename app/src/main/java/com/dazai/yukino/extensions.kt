package com.dazai.yukino

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dazai.yukino.activities.FoodDetailActivity
import com.dazai.yukino.data.vos.*

/**
 * Created by Moe Htet on 27,October,2020
 */

fun ImageView.loadImage(url: String) = Glide.with(this.context)
    .load(url)
    .placeholder(R.drawable.ic_launcher_background)
    .into(this)

fun ImageView.loadAsCircleImage(url: String) = Glide.with(this.context)
    .load(url)
    .apply(RequestOptions().circleCrop())
    .placeholder(R.drawable.ic_launcher_background)
    .into(this)


fun Map<String, Any>?.toFoodVO(): FoodVO {
    return FoodVO(
        id = this?.get("id") as String,
        price =( this?.get("price") as Long).toInt(),
        name = this?.get("name") as String,
        imageUrl = this?.get("image_url") as String,
        ingredients = this?.get("ingredients") as String,
        popular = this?.get("popular") as Boolean,
        ratings = (this?.get("ratings") as Long).toInt(),
        stars = if(this?.get("stars") is Double) (this?.get("stars") as Double) else
            (this?.get("stars") as Long).toDouble()
    )
}

fun Map<String, Any>?.toFoodTypeVO() : FoodTypeVO{
    return FoodTypeVO(
        id = this?.get("id") as String,
        name = this?.get("name") as String,
        imgUrl = this?.get("img_url") as String
    )
}

fun Map<String, Any>?.toCartWrapper() : CartItemWrapper{
    return CartItemWrapper(
        food = (this?.get("food") as Map<String,Any>?).toFoodVO(),
        quantity = (this?.get("quantity") as Long).toInt()
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
    val availFoods = this?.get("avail_foods") as ArrayList<Map<String,Any>>
    availFoods?.let {
        it.forEach { food ->
            tempAvailFoods.add(food.toFoodVO())
        }
    }
    return RestaurantVO(
       stars = if (this?.get("stars") is Double) this?.get("stars") as Double else
           (this?.get("stars") as Long).toDouble(),
        id = this?.get("id") as String,
        ratings = (this?.get("ratings") as Long).toInt(),
        name = this?.get("name") as String,
        availFoods = tempAvailFoods,
        location = this?.get("location") as String,
        shopImgUrl = this?.get("shop_img_url") as String
    )
}

fun FoodVO.toHashMap() : HashMap<String,Any>{
    return hashMapOf(
        "price" to this.price,
        "image_url" to this.imageUrl,
        "ratings" to this.ratings,
        "name" to this.name,
        "ingredients" to this.ingredients,
        "id" to this.id,
        "stars" to this.stars,
        "popular" to this.popular
    )
}
