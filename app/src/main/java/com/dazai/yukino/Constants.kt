package com.dazai.yukino

import com.dazai.yukino.data.ui_model.SliderModel
import java.util.*

/**
 * Created by Moe Htet on 28,October,2020
 */

const val NO_INTERNET_CONNECTION = "No Internet Connection"


val onBoardScreenData = listOf(
    SliderModel(imgUrl = "https://assets.materialup.com/uploads/b16b9a06-13f5-443a-87b1-a6aa962601ea/preview.jpg",
        title = "Finds Food You Love",
        desc = "Discover the best foods from over 1,000 restaurants"),
    SliderModel(
        imgUrl = "https://www.tecocraft.com/wp-content/uploads/2018/05/location-250x250.png",
        title = "Live Tracking",
        desc = "Real time tracking of the food after you ordered"
    ),
    SliderModel(
     imgUrl = "https://thumbs.dreamstime.com/z/express-delivery-service-logo-fast-time-order-stopwatch-quick-shipping-icon-152284290.jpg",
     title = "Fast Delivery",
        desc = "Fast delivery to your home , office wherever you are"
    )
)