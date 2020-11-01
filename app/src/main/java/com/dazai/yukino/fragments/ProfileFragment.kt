package com.dazai.yukino.fragments

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.dazai.yukino.R
import com.dazai.yukino.loadAsCircleImage
import com.dazai.yukino.mvp.presenters.ProfilePresenter
import com.dazai.yukino.mvp.presenters.impls.ProfilePresenterImpl
import com.dazai.yukino.mvp.views.ProfileView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.ktx.userProfileChangeRequest
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_profile.*
import java.io.ByteArrayOutputStream
import java.io.IOException

class ProfileFragment : Fragment(),ProfileView {

    var tempBitmap : Bitmap? = null

    companion object{
        const val UPLOAD_IMAGE = 3131
    }

    private fun preparePickIntent() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(
            Intent.createChooser(intent, "Select Picture"),
            UPLOAD_IMAGE
        )
    }

    lateinit var profilePresenter: ProfilePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    private fun setupPresenter(){
        profilePresenter = ViewModelProviders.of(this).get(ProfilePresenterImpl::class.java)
        profilePresenter.initPresenter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        setupPresenter()

        profilePresenter.onUiReady()

        btnSaveProfile.setOnClickListener {
            tempBitmap?.let { it1 ->
                profilePresenter.updateProfile(etProfileMail.text.toString(),
                    it1
                )
            }
        }

        btnUploadProfileImg.setOnClickListener {
            preparePickIntent()
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == UPLOAD_IMAGE && resultCode == Activity.RESULT_OK) {
            if (data == null || data.data == null) {
                return
            }

            val filePath = data.data

            try {

                filePath?.let {
                    if (Build.VERSION.SDK_INT >= 29) {
                        val source: ImageDecoder.Source =
                            ImageDecoder.createSource(requireContext().contentResolver, filePath)
                        val bitmap = ImageDecoder.decodeBitmap(source)
                        tempBitmap = bitmap
                    } else {
                        val bitmap = MediaStore.Images.Media.getBitmap(
                            requireContext().contentResolver, filePath
                        )
                        tempBitmap = bitmap
                    }

                    ivProfile.setImageBitmap(tempBitmap)
                   // ivProfile.background = resources.getDrawable(R.drawable.circle_img_background)

                }

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

    }

    private fun getUriFromBitmap(context: Context,bitmap: Bitmap) : Uri{
        val bytes =  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        val path = MediaStore.Images.Media.insertImage(context.contentResolver, bitmap, "Title", null);
        return Uri.parse(path);
    }


    override fun showUserProfile(firebaseUser: FirebaseUser) {
        etProfileMail.setText(firebaseUser.email)
        firebaseUser.photoUrl?.let {
            ivProfile.loadAsCircleImage(it.toString())
        }
    }

    override fun showSuccessUpdateMessage(message: String) {
        Snackbar.make(requireView(),message,Snackbar.LENGTH_SHORT).show()
    }

    override fun showErrorMessage(message: String) {
        Snackbar.make(requireView(),message,Snackbar.LENGTH_SHORT).show()
    }

}