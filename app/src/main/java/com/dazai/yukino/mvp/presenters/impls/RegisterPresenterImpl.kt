package com.dazai.yukino.mvp.presenters.impls

import com.dazai.yukino.base.AbstractBasePresenter
import com.dazai.yukino.data.model.AuthModel
import com.dazai.yukino.data.model.AuthModelImpl
import com.dazai.yukino.mvp.presenters.RegisterPresenter
import com.dazai.yukino.mvp.views.RegisterView

/**
 * Created by Moe Htet on 30,October,2020
 */
class RegisterPresenterImpl : AbstractBasePresenter<RegisterView>(), RegisterPresenter {

    private val authModel : AuthModel = AuthModelImpl

    override fun onTapRegister(mail: String, password: String, name: String, phone: String) {
        authModel.register(mail,password,name,onSuccess = {
            mView?.navigateToLogin()
        },onFailure = {
            mView?.showErrorMessage(it)
        })
    }


}