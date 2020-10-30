package com.dazai.yukino.data.model

import com.dazai.yukino.network.auth.AuthManager

/**
 * Created by Moe Htet on 30,October,2020
 */
interface AuthModel {

    var authModel : AuthManager

    fun login(mail : String,password :String,onSuccess: () -> Unit, onFailure: (String) -> Unit)

    fun register(
        email: String,
        password: String,
        userName: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    )

}