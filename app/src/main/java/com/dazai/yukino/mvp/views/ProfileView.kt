package com.dazai.yukino.mvp.views

import com.dazai.yukino.base.BaseView
import com.google.firebase.auth.FirebaseUser

/**
 * Created by Moe Htet on 31,October,2020
 */
interface ProfileView : BaseView {
    fun showUserProfile(firebaseUser : FirebaseUser)
}