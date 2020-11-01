package com.dazai.yukino.views.viewholders

import android.view.View
import com.dazai.yukino.R
import com.dazai.yukino.base.BaseViewHolder
import com.dazai.yukino.data.vos.CartItemWrapper
import kotlinx.android.synthetic.main.viewholer_cart_item.view.*

/**
 * Created by Moe Htet on 01,November,2020
 */
class CartViewHolder(itemView: View) : BaseViewHolder<CartItemWrapper>(itemView) {
    override fun bindData(data: CartItemWrapper) {
        itemView.tvCartItemPrice.text = "$${data.quantity*data.food.price}"
        val formatted = itemView.context.resources.getString(R.string.cart_item_with_name_name_and_qty,data.food.name,data.quantity)
        itemView.tvCartItemNameAndQty.text = formatted
    }
}