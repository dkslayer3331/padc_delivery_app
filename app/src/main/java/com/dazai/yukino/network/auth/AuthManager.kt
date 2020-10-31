package com.dazai.yukino.network.auth

import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest

/**
 * Created by Moe Htet on 30,October,2020
 */
interface AuthManager {
    fun login(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
    fun register(email: String, password: String, userName: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
    fun getUserProfile() : FirebaseUser?
    fun updateProfile(email : String, changeRequest: UserProfileChangeRequest, onSuccess: (FirebaseUser) -> Unit, onFailure: (String) -> Unit)
}