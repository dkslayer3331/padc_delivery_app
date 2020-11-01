package com.dazai.yukino.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dazai.yukino.R
import com.dazai.yukino.loadImage
import kotlinx.android.synthetic.main.activity_onboard_scren_one.*

class OnboardScrenOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard_scren_one)

        btnGettingStarted.setOnClickListener {
            val intent = Intent(this,OnboardScreenTwo::class.java)
            startActivity(intent)
        }

        ivBannerOnBoardOne.loadImage("https://assets.materialup.com/uploads/b16b9a06-13f5-443a-87b1-a6aa962601ea/preview.jpg")

    }
}