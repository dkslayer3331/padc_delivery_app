package com.dazai.yukino.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.dazai.yukino.R
import com.dazai.yukino.adapters.FoodAdapter
import com.dazai.yukino.data.vos.FoodVO
import com.dazai.yukino.data.vos.RestaurantVO
import com.dazai.yukino.mvp.presenters.RestaurantDetailPresenter
import com.dazai.yukino.mvp.presenters.impls.RestaurantDetailPresenterImpl
import com.dazai.yukino.mvp.views.RestaurantDetailView
import kotlinx.android.synthetic.main.activity_food_detail.*

class FoodDetailActivity : AppCompatActivity() , RestaurantDetailView{

    companion object{

        const val IE_ID = "IE_ID"

        fun onNewIntent(context: Context,id : String) = Intent(context,FoodDetailActivity::class.java).apply {
            putExtra(IE_ID,id)
        }

    }

    lateinit var allFoodAdapter : FoodAdapter

    lateinit var popularFoodAdapter: FoodAdapter

    lateinit var detailPresenter: RestaurantDetailPresenter

    private fun setupPresenter(){
        detailPresenter = ViewModelProviders.of(this).get(RestaurantDetailPresenterImpl::class.java)
        detailPresenter.initPresenter(this)
    }

    private fun setupAllAdapters(){
        allFoodAdapter = FoodAdapter(false)
        popularFoodAdapter = FoodAdapter(true)
        rvPopularFood.adapter = popularFoodAdapter
        rvAllFoodOfType.adapter = allFoodAdapter
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        val restaurantId = intent.getStringExtra(IE_ID)

        setupAllAdapters()

        setupPresenter()

        restaurantId?.let { detailPresenter.onUiReady(it) }

    }

    override fun showDetail(restaurantVO: RestaurantVO) {
        tvDetailRestName.text = restaurantVO.name
        tvDetailFoodStar.text = "${restaurantVO.stars}"
        tvDetailRestRating.text = "(${restaurantVO.ratings} ratings)"
    }

    override fun showPopularFoods(list: List<FoodVO>) {
        popularFoodAdapter.setNewData(list.toMutableList())
    }

    override fun showAllFoods(list: List<FoodVO>) {
        Log.d("allfoods","${list.size}")
        allFoodAdapter.setNewData(list.toMutableList())
    }

    override fun showErrorMessage(message: String) {
    }
}