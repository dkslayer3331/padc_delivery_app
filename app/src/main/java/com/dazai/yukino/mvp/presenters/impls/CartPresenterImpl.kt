package com.dazai.yukino.mvp.presenters.impls

import com.dazai.yukino.base.AbstractBasePresenter
import com.dazai.yukino.data.model.DeliveryModel
import com.dazai.yukino.data.model.DeliveryModelImpl
import com.dazai.yukino.mvp.presenters.CartPresenter
import com.dazai.yukino.mvp.views.CartView

/**
 * Created by Moe Htet on 01,November,2020
 */
class CartPresenterImpl : AbstractBasePresenter<CartView>(), CartPresenter {

    val model : DeliveryModel = DeliveryModelImpl

    override fun onUiReady() {
        model.getCartItems(onSuccess = {
            if(it.isEmpty()){
                mView?.showEmptyCartView()
            }else{
               mView?.displayCartItems(it)
                var total = 0L
                it.forEach {
                    total += it.quantity * it.food.price
                }
                mView?.showSubTotal(total)
            }
        },onFail = {

        })
    }

    override fun onCartClear(ids: List<String>) {
        model.clearCart(ids)
    }
}