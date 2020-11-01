package com.dazai.yukino.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.dazai.yukino.R
import com.dazai.yukino.adapters.CartAdapter
import com.dazai.yukino.data.vos.CartItemWrapper
import com.dazai.yukino.fragments.ModalBottomSheet
import com.dazai.yukino.loadImage
import com.dazai.yukino.mvp.presenters.CartPresenter
import com.dazai.yukino.mvp.presenters.impls.CartPresenterImpl
import com.dazai.yukino.mvp.views.CartView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.bottom_sheet_layout.*

class CartActivity : AppCompatActivity() , CartView{

    companion object{
        fun onNewIntent(context: Context) = Intent(context,CartActivity::class.java)
    }

    lateinit var cartAdapter: CartAdapter

    lateinit var cartPresenter: CartPresenter

    private fun setupAdapter(){
        cartAdapter = CartAdapter(cartPresenter)
        rvCartItems.adapter = cartAdapter
    }

    private fun setupPresenter(){
        cartPresenter = ViewModelProviders.of(this).get(CartPresenterImpl::class.java)
        cartPresenter.initPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        setupPresenter()

        setupAdapter()

        cartPresenter.onUiReady()

        btnCheckOut.setOnClickListener {
            cartPresenter.onCartClear(cartAdapter.mData.map { it.food.id })
        val modalBottomSheet = ModalBottomSheet()
            modalBottomSheet.show(supportFragmentManager,"MODAL_SHEET")
        }

    }

    override fun displayCartItems(items: List<CartItemWrapper>) {
        emptyView.visibility = View.GONE
        cartView.visibility = View.VISIBLE
        cartAdapter.setNewData(items.toMutableList())
    }

    override fun showEmptyCartView() {
        cartView.visibility = View.GONE
        emptyView.visibility = View.VISIBLE
        ivEmptyCart.loadImage("https://cdn.dribbble.com/users/1244867/screenshots/4346888/empty_cart.jpg")
    }

    override fun showSubTotal(total: Long) {
        tvCartTotal.text = "$${total}"
    }

    override fun showErrorMessage(message: String) {
        Snackbar.make(window.decorView,message,Snackbar.LENGTH_SHORT).show()
    }
}