package com.dazai.yukino.network

import com.dazai.yukino.NO_INTERNET_CONNECTION
import com.dazai.yukino.data.vos.CartItemWrapper
import com.dazai.yukino.data.vos.FoodTypeVO
import com.dazai.yukino.data.vos.RestaurantVO
import com.dazai.yukino.toFoodTypeVO
import com.dazai.yukino.toRestaurantVO
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

/**
 * Created by Moe Htet on 28,October,2020
 */
object CloudFireStoreImpl : DeliveryApi {

    private val fireStore = Firebase.firestore

    override fun getFoodTypes(onSuccess: (List<FoodTypeVO>) -> Unit, onFail: (String) -> Unit) {
        fireStore.collection("food_types").addSnapshotListener { value, error ->
            error?.let {
                onFail(error.message ?: NO_INTERNET_CONNECTION)
            } ?: run {
                val tempList = mutableListOf<FoodTypeVO>()
                val documents = value?.documents ?: emptyList()

               documents.forEach {
                   val data = it.data.toFoodTypeVO()
                   tempList.add(data)
               }

                onSuccess(tempList)

            }
        }
    }

    override fun getRestaurants(onSuccess: (List<RestaurantVO>) -> Unit, onFail: (String) -> Unit) {
        fireStore.collection("restaurants").addSnapshotListener { value, error ->
            error?.let {
                onFail(error.message ?: NO_INTERNET_CONNECTION)
            } ?: run {
                val tempList = mutableListOf<RestaurantVO>()
                val documents = value?.documents ?: emptyList()

                documents.forEach {
                    val data = it.data.toRestaurantVO()
                    tempList.add(data)
                }

                onSuccess(tempList)

            }
        }
    }

    override fun getCartItems(
        onSuccess: (List<CartItemWrapper>) -> Unit,
        onFail: (String) -> Unit
    ) {

    }


}