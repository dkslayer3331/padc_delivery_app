package com.dazai.yukino.network

import com.dazai.yukino.NO_INTERNET_CONNECTION
import com.dazai.yukino.data.vos.CartVO
import com.dazai.yukino.data.vos.FoodVO
import com.dazai.yukino.data.vos.RestaurantVO
import com.dazai.yukino.toCartVO
import com.dazai.yukino.toFoodVO
import com.dazai.yukino.toRestaurantVO
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

/**
 * Created by Moe Htet on 28,October,2020
 */
object CloudFireStoreImpl : DeliveryApi {

    private val fireStore = Firebase.firestore

    override fun getRestaurants(onSuccess: (List<RestaurantVO>) -> Unit, onFail: (String) -> Unit) {

        fireStore.collection("gg").document()

        fireStore.collection("restaurants").addSnapshotListener { value, error ->
            error?.let {
                onFail(error.localizedMessage ?: NO_INTERNET_CONNECTION)
            } ?: run {
              val datas = value?.documents ?: emptyList()
              val tempList = mutableListOf<RestaurantVO>()

                datas.forEach {
                    tempList.add(it.data.toRestaurantVO())
                }

                onSuccess(tempList)

            }
        }
    }

    override fun getFoods(onSuccess: (List<FoodVO>) -> Unit, onFail: (String) -> Unit) {
        fireStore.collection("food").addSnapshotListener { value, error ->
            error?.let {
                onFail(error.message ?: NO_INTERNET_CONNECTION)
            } ?: run{
                val temp = mutableListOf<FoodVO>()
                 val datas = value?.documents ?: emptyList()

                for(data in datas){
                    temp.add(data.data.toFoodVO())
                }

                onSuccess(temp)

            }
        }
    }

    override fun getCartItems(
        userId: String,
        onSuccess: (CartVO) -> Unit,
        onFail: (String) -> Unit
    ) {
        fireStore.collection("cart").addSnapshotListener { value, error ->
            error?.let {
                onFail(error.message ?: NO_INTERNET_CONNECTION)
            } ?: run {
                val datas = value?.documents ?: emptyList()
                val cartList = mutableListOf<CartVO>()
                for(data in datas){
                    val data = data.data
                    cartList.add(data.toCartVO())
                }

                onSuccess(cartList.first { it.userId == userId })

            }
        }
    }

    override fun addToCart(foodVO: FoodVO) {

    }

}