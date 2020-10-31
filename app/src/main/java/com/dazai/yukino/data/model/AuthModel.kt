package com.dazai.yukino.data.model

import com.dazai.yukino.network.auth.AuthManager
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest

/**
 * Created by Moe Htet on 30,October,2020
 */
interface AuthModel {

    var authModel : AuthManager

    fun login(mail : String,password :String,onSuccess: () -> Unit, onFailure: (String) -> Unit)

    fun register(
        email: String,
        password: String,
        userName: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )

    fun getUserProfile() : FirebaseUser?

    fun updateProfile(mail : String, changeRequest: UserProfileChangeRequest, onSuccess: (FirebaseUser) -> Unit, onFailure: (String) -> Unit)

}