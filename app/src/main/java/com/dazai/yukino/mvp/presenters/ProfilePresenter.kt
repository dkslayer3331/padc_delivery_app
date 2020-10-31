package com.dazai.yukino.mvp.presenters

import com.dazai.yukino.base.BasePresenter
import com.dazai.yukino.mvp.views.ProfileView
import com.google.firebase.auth.UserProfileChangeRequest

/**
 * Created by Moe Htet on 31,October,2020
 */
interface ProfilePresenter : BasePresenter<ProfileView> {
    fun onUiReady()
    fun updateProfile(email : String , userProfileChangeRequest : UserProfileChangeRequest)
}