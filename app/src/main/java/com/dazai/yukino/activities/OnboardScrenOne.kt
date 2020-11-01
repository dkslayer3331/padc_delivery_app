package com.dazai.yukino.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dazai.yukino.R
import kotlinx.android.synthetic.main.activity_onboard_scren_one.*

class OnboardScrenOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard_scren_one)

        btnGettingStarted.setOnClickListener {
            val intent = LoginActivity.newIntent(this)
            startActivity(intent)
        }

    }
}