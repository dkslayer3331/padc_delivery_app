package com.dazai.yukino.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dazai.yukino.R
import com.dazai.yukino.base.BaseRecyclerAdapter
import com.dazai.yukino.data.vos.CartItemWrapper
import com.dazai.yukino.data.vos.CartVO
import com.dazai.yukino.views.viewholders.CartViewHolder

/**
 * Created by Moe Htet on 01,November,2020
 */
class CartAdapter : BaseRecyclerAdapter<CartViewHolder, CartItemWrapper>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholer_cart_item,parent,false)
        return  CartViewHolder(view)
    }
}