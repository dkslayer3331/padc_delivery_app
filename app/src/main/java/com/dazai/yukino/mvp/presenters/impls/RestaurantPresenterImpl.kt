package com.dazai.yukino.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.dazai.yukino.base.AbstractBasePresenter
import com.dazai.yukino.data.model.DeliveryModel
import com.dazai.yukino.data.model.DeliveryModelImpl
import com.dazai.yukino.mvp.presenters.RestaurantPresenter
import com.dazai.yukino.mvp.views.RestaurantView

/**
 * Created by Moe Htet on 30,October,2020
 */
class RestaurantPresenterImpl : AbstractBasePresenter<RestaurantView>(),RestaurantPresenter {

    private var deliveryModel : DeliveryModel = DeliveryModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        mView?.showRelevantView(deliveryModel.getMainScreenMode())

        deliveryModel.getFoodTypes(onSuccess = {
            it.observe(lifecycleOwner, Observer {
                mView?.showShowFoodTypes(it)
            })
        },onFail = {
            mView?.showErrorMessage(it)
        })

        deliveryModel.getRestaurants(onSuccess = {
            it.observe(lifecycleOwner, Observer {
                mView?.showRestaurants(it)
            })
        },onFail = {
            mView?.showErrorMessage(it)
        })

    }

}