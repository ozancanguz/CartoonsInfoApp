package com.ozancanguz.cartoonsinfoapp.data.network

import com.ozancanguz.cartoonsinfoapp.data.model.Cartoon
import retrofit2.Response
import retrofit2.http.GET

interface CartoonApi {

    @GET("api")
    suspend fun getCartoons(): Response<Cartoon>

}