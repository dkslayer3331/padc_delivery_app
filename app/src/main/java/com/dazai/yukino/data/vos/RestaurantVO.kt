package com.dazai.yukino.data.vos

import com.google.gson.annotations.SerializedName

data class RestaurantVO(

	@SerializedName("stars")
	var stars: Double = 0.0,

	@SerializedName("ratings")
	var ratings: Int= 0,

	@SerializedName("name")
	var name: String = "",

	@SerializedName("location")
	var location: String = "",

	@SerializedName("id")
	var id: String,

	@SerializedName("shop_img_url")
	var shopImgUrl: String = "",

	@SerializedName("avail_foods")
	var availFoods: List<FoodVO> = listOf()
)

