package com.ysanjeet535.drinksapp.data

import com.ysanjeet535.drinksapp.data.remote.DrinksApi
import javax.inject.Inject

class DrinksRepository @Inject constructor(val drinksApi: DrinksApi) {

    suspend fun getDrinks(query : String) = drinksApi.getDrinks(query)

}