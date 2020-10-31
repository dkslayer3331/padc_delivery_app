package com.dazai.yukino.data.model

import com.dazai.yukino.network.auth.AuthManager
import com.dazai.yukino.network.auth.FirebaseAuthManager
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.ktx.Firebase

/**
 * Created by Moe Htet on 30,October,2020
 */
object AuthModelImpl : AuthModel {

    override var authModel: AuthManager = FirebaseAuthManager

    override fun login(
        mail: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        authModel.login(mail,password,onSuccess, onFailure)
    }

    override fun register(
        email: String,
        password: String,
        userName: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        authModel.register(email, password, userName, onSuccess, onFailure)
    }

    override fun getUserProfile(): FirebaseUser?  = authModel.getUserProfile()

    override fun updateProfile(
        mail: String,
        changeRequest: UserProfileChangeRequest,
        onSuccess: (FirebaseUser) -> Unit,
        onFailure: (String) -> Unit
    ) {
        authModel.updateProfile(mail, changeRequest, onSuccess, onFailure)
    }
}