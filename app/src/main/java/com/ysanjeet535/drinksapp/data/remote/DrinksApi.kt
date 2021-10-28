package com.ysanjeet535.drinksapp.data.remote

import com.ysanjeet535.drinksapp.data.remote.dto.DrinksResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinksApi {
    @GET("search.php")
    suspend fun getDrinks(@Query("s") query : String) : Response<DrinksResponse>
}