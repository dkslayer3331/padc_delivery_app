package com.dazai.yukino.mvp.presenters.impls

import android.graphics.Bitmap
import android.net.Uri
import com.dazai.yukino.base.AbstractBasePresenter
import com.dazai.yukino.data.model.AuthModel
import com.dazai.yukino.data.model.AuthModelImpl
import com.dazai.yukino.mvp.presenters.ProfilePresenter
import com.dazai.yukino.mvp.views.ProfileView
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import java.io.ByteArrayOutputStream
import java.util.*

/**
 * Created by Moe Htet on 31,October,2020
 */
class ProfilePresenterImpl : AbstractBasePresenter<ProfileView>(),ProfilePresenter {

    private val authModel : AuthModel = AuthModelImpl

    val db = Firebase.firestore
    private val storage = FirebaseStorage.getInstance()
    private val storageReference = storage.reference

    override fun onUiReady() {
        authModel.getUserProfile()?.let {
            mView?.showUserProfile(it)
        }
    }

    override fun updateProfile(email: String, image: Bitmap) {
            uploadProfile(email,image)
    }


    private fun uploadProfile(email: String, image: Bitmap) {
        val baos = ByteArrayOutputStream()
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()

        val imageRef = storageReference.child("images/${UUID.randomUUID()}")
        val uploadTask = imageRef.putBytes(data)
        uploadTask.addOnFailureListener {

        }.addOnSuccessListener { taskSnapshot ->

        }

        val urlTask = uploadTask.continueWithTask {
            return@continueWithTask imageRef.downloadUrl
        }.addOnCompleteListener { task ->
            val imageUrl = task.result?.toString()

            val userProfileChangeRequest = userProfileChangeRequest {
                photoUri = Uri.parse(imageUrl)
            }

            authModel.updateProfile(email,userProfileChangeRequest,onFailure = {
                mView?.showErrorMessage(it)
            },onSuccess = {
                mView?.showUserProfile(it)
                mView?.showSuccessUpdateMessage("Your profile has been updated.")
            })
        }

    }

}