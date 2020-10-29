package com.dazai.yukino

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.dazai.yukino.fragments.OfferFragment
import com.dazai.yukino.fragments.ProfileFragment
import com.dazai.yukino.fragments.RestaurantFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val restaurantFragment = RestaurantFragment()
    private val profileFragment = ProfileFragment()
    private val offerFragment = OfferFragment()

    val fragmentManager = supportFragmentManager

    var active : Fragment = restaurantFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager.beginTransaction().add(R.id.fragmentContainer,offerFragment).hide(offerFragment).commit()
        fragmentManager.beginTransaction().add(R.id.fragmentContainer,profileFragment).hide(profileFragment).commit()
        fragmentManager.beginTransaction().add(R.id.fragmentContainer,restaurantFragment).commit()

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