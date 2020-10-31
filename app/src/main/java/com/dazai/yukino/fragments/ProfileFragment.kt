package com.dazai.yukino.fragments

import android.net.Uri
import android.os.Bundle
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
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.ktx.userProfileChangeRequest
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(),ProfileView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    lateinit var profilePresenter: ProfilePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
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
            val changeRequest = userProfileChangeRequest{
            }
            profilePresenter.updateProfile(etProfileMail.text.toString(),changeRequest)
        }

    }

    override fun showUserProfile(firebaseUser: FirebaseUser) {
        etProfileMail.setText(firebaseUser.email)
        firebaseUser.photoUrl?.let {
            if(it.toString().isNotEmpty())
            ivProfile.loadAsCircleImage(it.toString())
        }
    }

    override fun showErrorMessage(message: String) {

    }

}