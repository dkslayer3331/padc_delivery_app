package com.dazai.yukino.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dazai.yukino.R
import com.dazai.yukino.adapters.SliderAdapter
import com.dazai.yukino.onBoardScreenData
import kotlinx.android.synthetic.main.activity_onboard_screen_two.*

class OnboardScreenTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard_screen_two)

        val sliderAdapter = SliderAdapter(onBoardScreenData)

        sliderView.setSliderAdapter(sliderAdapter)

        tvLogin.setOnClickListener {
            startActivity(LoginActivity.newIntent(this))
        }

        btnSignUp.setOnClickListener {
            startActivity(RegisterActivity.newIntent(this))
        }

    }
}