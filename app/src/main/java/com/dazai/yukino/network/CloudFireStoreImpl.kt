package com.dazai.yukino.network

import android.content.Context
import android.util.Log
import com.dazai.yukino.*
import com.dazai.yukino.data.model.BaseModel
import com.dazai.yukino.data.vos.CartItemWrapper
import com.dazai.yukino.data.vos.FoodTypeVO
import com.dazai.yukino.data.vos.FoodVO
import com.dazai.yukino.data.vos.RestaurantVO
import com.dazai.yukino.persistance.database.DeliveryDb
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

/**
 * Created by Moe Htet on 28,October,2020
 */
object CloudFireStoreImpl : DeliveryApi , BaseModel(){

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
        fireStore.collection("cart").addSnapshotListener { value, error ->
            error?.let {
                onFail(it.message ?: NO_INTERNET_CONNECTION)
            }   ?: run {
                val tempList = mutableListOf<CartItemWrapper>()
                val documents = value?.documents ?: emptyList()

                documents.forEach {
                    val data = it.data.toCartWrapper()
                    tempList.add(data)
                }

                onSuccess(tempList)
            }
        }
    }

    override fun addToCart(foodVO: FoodVO, onSuccess: () -> Unit, onFail: (String) -> Unit) {

        val data = hashMapOf(
            "food" to foodVO.toHashMap(),
            "quantity" to 1
        )

          fireStore.collection("cart").document(foodVO.id)
              .set(data)
              .addOnSuccessListener {
                  Log.d("insideStore","completed")
                  onSuccess()
              }
              .addOnFailureListener {
                  onFail(it.message ?: NO_INTERNET_CONNECTION)
              }
    }

    override fun clearCart(ids: List<String>) {
        ids.forEach {
            fireStore.collection("cart").document(it).delete()
                .addOnCompleteListener {
                    Log.d("delete","complete")
                }
                .addOnFailureListener {
                    Log.d("delete","fail")
                }
        }
    }

}