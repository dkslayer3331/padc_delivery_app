package com.dazai.yukino.network.auth

import com.dazai.yukino.NO_INTERNET_CONNECTION
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.ktx.Firebase

/**
 * Created by Moe Htet on 30,October,2020
 */
object FirebaseAuthManager : AuthManager {

    private val firebaseAuth = FirebaseAuth.getInstance()

    override fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            if(it.isSuccessful && it.isComplete) {
                onSuccess()
            } else {
                onFailure(it.exception?.localizedMessage ?: NO_INTERNET_CONNECTION)
            }
        }
    }

    override fun register(
        email: String,
        password: String,
        userName: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
            if(it.isSuccessful && it.isComplete){
                firebaseAuth.currentUser?.updateProfile(
                    UserProfileChangeRequest.Builder().setDisplayName(userName).build())
                onSuccess()
            }
            else {
                onFailure(it.exception?.localizedMessage ?: NO_INTERNET_CONNECTION)
            }
        }
    }
}