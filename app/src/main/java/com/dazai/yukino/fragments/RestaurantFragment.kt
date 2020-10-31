package com.dazai.yukino.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.dazai.yukino.R
import com.dazai.yukino.adapters.FoodTypeAdapter
import com.dazai.yukino.adapters.RestaurantAdapter
import com.dazai.yukino.data.vos.FoodTypeVO
import com.dazai.yukino.data.vos.RestaurantVO
import com.dazai.yukino.mvp.presenters.RestaurantPresenter
import com.dazai.yukino.mvp.presenters.impls.RestaurantPresenterImpl
import com.dazai.yukino.mvp.views.RestaurantView
import kotlinx.android.synthetic.main.fragment_restaurant.*

class RestaurantFragment : Fragment(), RestaurantView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    lateinit var foodTypeAdapter: FoodTypeAdapter

    lateinit var restaurantPresenter: RestaurantPresenter

    private lateinit var restaurantAdapter: RestaurantAdapter

    private fun setupFoodTypeAdapter(){
        foodTypeAdapter = FoodTypeAdapter()
        rvFoodType.adapter = foodTypeAdapter
    }

    private fun setupRestaurantAdapter(){
        restaurantAdapter = RestaurantAdapter()
        rvRestaurants.adapter = restaurantAdapter
    }

    private fun setupPresenter(){
        restaurantPresenter = ViewModelProviders.of(this).get(RestaurantPresenterImpl::class.java)
        restaurantPresenter.initPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant, container, false)
    }

    private fun setupAllAdapters(){
        setupFoodTypeAdapter()
        setupRestaurantAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        setupAllAdapters()

        setupPresenter()

        restaurantPresenter.onUiReady(this)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = RestaurantFragment()
    }

    override fun showRelevantView(type: Int) {
        when(type){
            1 -> groupForDifferentLayout.visibility = View.GONE
            2 -> groupForDifferentLayout.visibility = View.VISIBLE
            else -> Log.d("WrongViewType","unknown")
        }
    }

    override fun showShowFoodTypes(foodTypes: List<FoodTypeVO>) {
        foodTypeAdapter.setNewData(foodTypes.toMutableList())
    }

    override fun showRestaurants(restaurants: List<RestaurantVO>) {
        Log.d("restsize",restaurants.size.toString())
        restaurantAdapter.setNewData(restaurants.toMutableList())
    }

    override fun showErrorMessage(message: String) {

    }

}