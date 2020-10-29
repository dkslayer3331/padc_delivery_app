package com.dazai.yukino.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dazai.yukino.R
import com.dazai.yukino.fragments.ModalBottomSheet
import kotlinx.android.synthetic.main.activity_cart.*

class CartActivity : AppCompatActivity() {

    companion object{
        fun onNewIntent(context: Context) = Intent(context,CartActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        btnCheckOut.setOnClickListener {
        val modalBottomSheet = ModalBottomSheet()
            modalBottomSheet.show(supportFragmentManager,"MODAL_SHEET")
        }

    }
}