package com.dazai.yukino.network.auth

import android.util.Log
import com.dazai.yukino.NO_INTERNET_CONNECTION
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
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

    override fun getUserProfile(): FirebaseUser?  = firebaseAuth.currentUser

    override fun updateProfile(
        email: String,
        changeRequest: UserProfileChangeRequest,
        onSuccess: (FirebaseUser) -> Unit,
        onFailure: (String) -> Unit
    ) {
        if(email != firebaseAuth.currentUser?.email){
            firebaseAuth.currentUser?.updateEmail(email)?.addOnCompleteListener {
                if(it.isSuccessful && it.isComplete) Log.d("emailUpdate","Success")
                else it.exception?.localizedMessage?.let { it1 -> Log.d("emailUpdate", it1) }
            }
        }

       firebaseAuth.currentUser?.updateProfile(changeRequest)?.addOnCompleteListener { task ->
               if (task.isSuccessful) {

               }
           else task.exception?.localizedMessage?.let { onFailure(it) }
           }

    }
}