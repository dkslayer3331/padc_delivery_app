package com.dazai.yukino.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.dazai.yukino.base.AbstractBasePresenter
import com.dazai.yukino.mvp.presenters.RestaurantPresenter
import com.dazai.yukino.mvp.views.RestaurantView

/**
 * Created by Moe Htet on 30,October,2020
 */
object RestaurantPresenterImpl : AbstractBasePresenter<RestaurantView>(),RestaurantPresenter {

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

    }


}