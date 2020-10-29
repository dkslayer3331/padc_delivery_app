package com.dazai.yukino.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dazai.yukino.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    companion object{
        fun newIntent(context : Context)  = Intent(context,LoginActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tvSignUp.setOnClickListener {
            startActivity(RegisterActivity.newIntent(this))
        }

        btnLogin.setOnClickListener {
            startActivity(CartActivity.onNewIntent(this))
        }

    }
}