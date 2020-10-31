package com.dazai.yukino.mvp.presenters.impls

import com.dazai.yukino.base.AbstractBasePresenter
import com.dazai.yukino.data.model.DeliveryModel
import com.dazai.yukino.data.model.DeliveryModelImpl
import com.dazai.yukino.mvp.presenters.RestaurantDetailPresenter
import com.dazai.yukino.mvp.views.RestaurantDetailView

/**
 * Created by Moe Htet on 01,November,2020
 */
class RestaurantDetailPresenterImpl : AbstractBasePresenter<RestaurantDetailView>(), RestaurantDetailPresenter {

    private val model : DeliveryModel = DeliveryModelImpl

    override fun onUiReady(id: String) {
        val restaurant = model.getRestaurantById(id)
        val popularFoods = restaurant.availFoods.filter { it.popular }
        val allFoods = restaurant.availFoods
        mView?.showDetail(restaurant)
        mView?.showAllFoods(allFoods)
        mView?.showPopularFoods(popularFoods)
    }
}