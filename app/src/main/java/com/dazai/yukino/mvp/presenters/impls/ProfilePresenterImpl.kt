package com.dazai.yukino.mvp.presenters.impls

import com.dazai.yukino.base.AbstractBasePresenter
import com.dazai.yukino.data.model.AuthModel
import com.dazai.yukino.data.model.AuthModelImpl
import com.dazai.yukino.mvp.presenters.ProfilePresenter
import com.dazai.yukino.mvp.views.ProfileView
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest

/**
 * Created by Moe Htet on 31,October,2020
 */
class ProfilePresenterImpl : AbstractBasePresenter<ProfileView>(),ProfilePresenter {

    private val authModel : AuthModel = AuthModelImpl

    override fun onUiReady() {
        authModel.getUserProfile()?.let {
            mView?.showUserProfile(it)
        }
    }

    override fun updateProfile(email: String, userProfileChangeRequest: UserProfileChangeRequest) {
            authModel.updateProfile(email,userProfileChangeRequest,onFailure = {
                mView?.showErrorMessage(it)
            },onSuccess = {
                mView?.showUserProfile(it)
            })
    }
}