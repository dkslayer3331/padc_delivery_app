package com.dazai.yukino

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dazai.yukino.fragments.OfferFragment
import com.dazai.yukino.fragments.ProfileFragment
import com.dazai.yukino.fragments.RestaurantFragment

class MainActivity : AppCompatActivity() {

    private val restaurantFragment = RestaurantFragment()
    private val profileFragment = ProfileFragment()
    private val offerFragment = OfferFragment()

    val fragmentManager = supportFragmentManager

    val active = restaurantFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}