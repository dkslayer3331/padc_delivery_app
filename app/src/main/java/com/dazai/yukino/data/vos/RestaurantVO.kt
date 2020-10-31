package com.dazai.yukino.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.dazai.yukino.persistance.typeconverters.FoodVoListTypeConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "restaurants")
@TypeConverters(FoodVoListTypeConverter::class)
data class RestaurantVO(

	@SerializedName("stars")
	var stars: Double = 0.0,

	@SerializedName("ratings")
	var ratings: Int= 0,

	@SerializedName("name")
	var name: String = "",

	@SerializedName("location")
	var location: String = "",

	@PrimaryKey
	@SerializedName("id")
	var id: String = "",

	@SerializedName("shop_img_url")
	var shopImgUrl: String = "",

	@SerializedName("avail_foods")
	var availFoods: List<FoodVO> = listOf()
)

