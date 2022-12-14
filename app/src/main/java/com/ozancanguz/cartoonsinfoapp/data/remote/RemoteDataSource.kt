package com.ozancanguz.cartoonsinfoapp.data.remote

import com.ozancanguz.cartoonsinfoapp.data.model.Cartoon
import com.ozancanguz.cartoonsinfoapp.data.network.CartoonApi
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Response
import javax.inject.Inject


@AndroidEntryPoint
class RemoteDataSource@Inject constructor(private val cartoonApi: CartoonApi) {

    suspend fun getCartoons():Response<Cartoon>{

        return cartoonApi.getCartoons()
    }
}