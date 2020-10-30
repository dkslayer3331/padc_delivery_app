package com.dazai.yukino.activities

import androidx.appcompat.app.AppCompatActivity
import com.dazai.yukino.base.BaseView
import com.google.android.material.snackbar.Snackbar

/**
 * Created by Moe Htet on 27,October,2020
 */
abstract class BaseActivity : AppCompatActivity(),BaseView {

    override fun showErrorMessage(message : String){
          Snackbar.make(window.decorView,message,Snackbar.LENGTH_SHORT).show()
    }

}