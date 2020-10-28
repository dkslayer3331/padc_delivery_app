package com.dazai.yukino.data.vos

import com.google.gson.annotations.SerializedName

data class CartVO(

	@SerializedName("user_id")
	var userId: String = "",

	@SerializedName("cart_items")
	var cartItems: List<CartItemWrapper> = listOf(),

	@SerializedName("id")
	var id: String = ""
)

