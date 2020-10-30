package com.dazai.yukino.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.dazai.yukino.R
import com.dazai.yukino.base.BaseView
import com.dazai.yukino.mvp.presenters.LoginPresenter
import com.dazai.yukino.mvp.presenters.impls.LoginPresenterImpl
import com.dazai.yukino.mvp.views.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),LoginView {

    companion object{
        fun newIntent(context : Context)  = Intent(context,LoginActivity::class.java)
    }

    lateinit var loginPresenter: LoginPresenter

    private fun setupPresenter(){
        loginPresenter = ViewModelProviders.of(this).get(LoginPresenterImpl::class.java)
        loginPresenter.initPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setupPresenter()

        loginPresenter.onUiReady(this)

        tvSignUp.setOnClickListener {
            startActivity(RegisterActivity.newIntent(this))
        }

        btnLogin.setOnClickListener {
            startActivity(MainActivity.onNewIntent(this))
        }

    }

    override fun showError(message: String) {

    }
}