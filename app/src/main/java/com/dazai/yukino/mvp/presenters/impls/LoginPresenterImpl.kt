package com.dazai.yukino.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.dazai.yukino.base.AbstractBasePresenter
import com.dazai.yukino.data.model.AuthModel
import com.dazai.yukino.data.model.AuthModelImpl
import com.dazai.yukino.data.model.DeliveryModel
import com.dazai.yukino.data.model.DeliveryModelImpl
import com.dazai.yukino.mvp.presenters.LoginPresenter
import com.dazai.yukino.mvp.views.LoginView

/**
 * Created by Moe Htet on 30,October,2020
 */
class LoginPresenterImpl : AbstractBasePresenter<LoginView>(), LoginPresenter {

    private val deliveryModel : DeliveryModel = DeliveryModelImpl

    private val authModel : AuthModel = AuthModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        deliveryModel.setupRemoteConfigWithDefaultValues()
        deliveryModel.fetchRemoteConfigs()
    }

    override fun onLoginIn(mail: String, password: String) {
        authModel.login(mail,password,onSuccess = {
            mView?.navigateToMain()
        },onFailure = {
            mView?.showErrorMessage(it)
        })
    }
}