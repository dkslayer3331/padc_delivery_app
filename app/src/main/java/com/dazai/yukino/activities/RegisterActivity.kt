package com.dazai.yukino.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.dazai.yukino.R
import com.dazai.yukino.mvp.presenters.RegisterPresenter
import com.dazai.yukino.mvp.presenters.impls.RegisterPresenterImpl
import com.dazai.yukino.mvp.views.RegisterView
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity(),RegisterView{

    lateinit var registerPresenter: RegisterPresenter

    companion object{
        fun newIntent(context: Context) = Intent(context,RegisterActivity::class.java)
    }

    private fun setupPresenter(){
        registerPresenter = ViewModelProviders.of(this).get(RegisterPresenterImpl::class.java)
        registerPresenter.initPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setupPresenter()

        btnRegister.setOnClickListener {
            registerPresenter.onTapRegister(etRegMail.text.toString(),etRegPass.text.toString(),
            etRegName.text.toString())
        }

        tvAlrdyRegLogin.setOnClickListener {
            startActivity(LoginActivity.newIntent(this))
        }

    }

    override fun navigateToLogin() {
        startActivity(LoginActivity.newIntent(this))
    }

}