package com.dazai.yukino.base

/**
 * Created by Moe Htet on 27,October,2020
 */
interface BasePresenter<T : BaseView> {
    fun initPresenter(view: T)
}