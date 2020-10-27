package com.dazai.yukino.data.vos

import com.google.gson.annotations.SerializedName

data class CartVO(

	@SerializedName("quantity")
	var quantity: Int = 0,

	@SerializedName("user_id")
	var userId: String = "",

	@SerializedName("cart_items")
	var cartItems: List<FoodVO> = listOf(),

	@SerializedName("id")
	var id: String = ""
)

