package com.dazai.yukino.mvp.presenters

import com.dazai.yukino.base.BasePresenter
import com.dazai.yukino.delegates.CartItemDelegate
import com.dazai.yukino.mvp.views.CartView

/**
 * Created by Moe Htet on 01,November,2020
 */
interface CartPresenter : BasePresenter<CartView>, CartItemDelegate {
    fun onUiReady()
    fun onCartClear(ids : List<String>)
}