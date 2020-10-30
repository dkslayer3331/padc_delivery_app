package com.dazai.yukino.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.dazai.yukino.base.BasePresenter
import com.dazai.yukino.mvp.views.RestaurantView

/**
 * Created by Moe Htet on 30,October,2020
 */
interface RestaurantPresenter : BasePresenter<RestaurantView> {
    fun onUiReady(lifecycleOwner: LifecycleOwner)
}