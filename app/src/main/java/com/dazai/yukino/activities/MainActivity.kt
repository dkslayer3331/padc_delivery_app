package com.dazai.yukino.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dazai.yukino.R
import com.dazai.yukino.fragments.OfferFragment
import com.dazai.yukino.fragments.ProfileFragment
import com.dazai.yukino.fragments.RestaurantFragment
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        fun onNewIntent(context : Context) = Intent(context,MainActivity::class.java)
    }

    val ff = Firebase.auth.currentUser

    private val restaurantFragment = RestaurantFragment()
    private val profileFragment = ProfileFragment()
    private val offerFragment = OfferFragment()

    private val fragmentManager = supportFragmentManager

    private var active : Fragment = restaurantFragment
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        fragmentManager.beginTransaction().add(R.id.fragmentContainer,offerFragment,"offer").hide(offerFragment).commit()
        fragmentManager.beginTransaction().add(R.id.fragmentContainer,profileFragment,"profile").hide(profileFragment).commit()
        fragmentManager.beginTransaction().add(R.id.fragmentContainer,restaurantFragment,"restaurant").commit()

        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.actionOffer -> {
                    fragmentManager.beginTransaction().hide(active).show(offerFragment).commit()
                    active = offerFragment
                    true
                }
                R.id.actionProfile -> {
                    fragmentManager.beginTransaction().hide(active).show(profileFragment).commit()
                    active = profileFragment
                    true
                }
                R.id.actionRestaurant -> {
                    fragmentManager.beginTransaction().hide(active).show(restaurantFragment).commit()
                    active = restaurantFragment
                    true
                }
               else -> true
            }
        }

    }
}