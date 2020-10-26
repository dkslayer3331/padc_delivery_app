package com.dazai.yukino.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Moe Htet on 27,October,2020
 */
abstract class BaseViewHolder<T>(itemView: View)
    : RecyclerView.ViewHolder(itemView) {

    var mData : T? = null

    abstract fun bindData(data : T)
}