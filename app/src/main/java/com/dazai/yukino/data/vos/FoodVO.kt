package com.dazai.yukino.data.vos

import com.google.gson.annotations.SerializedName

data class FoodVO(

	@SerializedName("price")
	var price: Int = 0,

	@SerializedName("image_url")
	var imageUrl: String = "",

	@SerializedName("ratings")
	var ratings: Int = 0,

	@SerializedName("name")
	var name: String = "",

	@SerializedName("ingredients")
	var ingredients: String = "",

	@SerializedName("id")
	var id: String = "",

	@SerializedName("stars")
	var stars: Double = 0.0,

	@SerializedName("popular")
	var popular: Boolean = false,

	@SerializedName("type")
	var type : String = ""

)
