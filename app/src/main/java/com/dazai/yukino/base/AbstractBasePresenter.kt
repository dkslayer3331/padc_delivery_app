package com.dazai.yukino.base

import androidx.lifecycle.ViewModel

/**
 * Created by Moe Htet on 27,October,2020
 */
abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T>, ViewModel() {
    var mView: T? = null

    override fun initPresenter(view: T) {
        mView = view
    }
}