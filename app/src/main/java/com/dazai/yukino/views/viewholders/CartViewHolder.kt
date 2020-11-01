package com.dazai.yukino.views.viewholders

import android.view.View
import com.dazai.yukino.R
import com.dazai.yukino.base.BaseViewHolder
import com.dazai.yukino.data.vos.CartItemWrapper
import com.dazai.yukino.delegates.CartItemDelegate
import kotlinx.android.synthetic.main.viewholer_cart_item.view.*

/**
 * Created by Moe Htet on 01,November,2020
 */
class CartViewHolder(itemView: View, val cartItemDelegate: CartItemDelegate) : BaseViewHolder<CartItemWrapper>(itemView) {
    override fun bindData(data: CartItemWrapper) {
        mData = data
        itemView.tvCartItemPrice.text = "$${data.quantity*data.food.price}"
        val formatted = itemView.context.resources.getString(R.string.cart_item_with_name_name_and_qty,data.food.name,data.quantity)
        itemView.tvCartItemNameAndQty.text = formatted
        itemView.tvCartItemQty.text = "${data.quantity}"
    }

    init {
        itemView.btnAdd.setOnClickListener {
            mData?.let { it1 -> cartItemDelegate.onAdd(it1,1) }
        }
        itemView.btnRemove.setOnClickListener {
            mData?.let { cartItemDelegate.onReduce(it,1) }
        }
    }

}