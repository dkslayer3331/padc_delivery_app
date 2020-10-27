package com.dazai.yukino.network

import com.dazai.yukino.NO_INTERNET_CONNECTION
import com.dazai.yukino.data.vos.CartVO
import com.dazai.yukino.data.vos.FoodVO
import com.dazai.yukino.data.vos.RestaurantVO
import com.dazai.yukino.toFoodVO
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

/**
 * Created by Moe Htet on 28,October,2020
 */
object CloudFireStoreImpl : DeliveryApi {

    private val fireStore = Firebase.firestore

    override fun getRestaurants(onSuccess: (List<RestaurantVO>) -> Unit, onFail: (String) -> Unit) {

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

    }
}