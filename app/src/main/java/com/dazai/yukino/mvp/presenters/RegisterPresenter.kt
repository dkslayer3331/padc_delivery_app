package com.dazai.yukino.mvp.presenters

import com.dazai.yukino.base.BasePresenter
import com.dazai.yukino.base.BaseView
import com.dazai.yukino.mvp.views.RegisterView

/**
 * Created by Moe Htet on 30,October,2020
 */
interface RegisterPresenter : BasePresenter<RegisterView> {
    fun onTapRegister(mail : String,password : String, name : String,phone : String = "")
}