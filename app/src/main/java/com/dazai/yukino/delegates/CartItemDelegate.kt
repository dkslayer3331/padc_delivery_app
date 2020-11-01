package com.dazai.yukino.delegates

import com.dazai.yukino.data.vos.CartItemWrapper

/**
 * Created by Moe Htet on 01,November,2020
 */
interface CartItemDelegate {
    fun onAdd(cartItemWrapper: CartItemWrapper, qty : Int)
    fun onReduce(cartItemWrapper: CartItemWrapper, qty : Int)
}