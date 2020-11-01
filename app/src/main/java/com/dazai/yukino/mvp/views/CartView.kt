package com.dazai.yukino.mvp.views

import com.dazai.yukino.base.BaseView
import com.dazai.yukino.base.BaseViewHolder
import com.dazai.yukino.data.vos.CartItemWrapper

/**
 * Created by Moe Htet on 01,November,2020
 */
interface CartView : BaseView {
    fun displayCartItems(items : List<CartItemWrapper>)
    fun showEmptyCartView()
    fun showSubTotal(total : Long)
}