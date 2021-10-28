package com.ysanjeet535.drinksapp.view.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.*
import com.ysanjeet535.drinksapp.data.DrinksRepository
import com.ysanjeet535.drinksapp.data.remote.dto.Drink
import com.ysanjeet535.drinksapp.data.remote.dto.DrinksResponse
import com.ysanjeet535.drinksapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(application:Application, private val repository: DrinksRepository) : AndroidViewModel(application) {

    private val _drinks = MutableLiveData<Resource<DrinksResponse>>()

    val drinks : LiveData<Resource<DrinksResponse>> get() = _drinks

    lateinit var drinkDetailItem : Drink


    fun getDrinks(query:String){
        viewModelScope.launch(Dispatchers.IO) {
            if(isNetworkAvailable()){
                val response = repository.getDrinks(query = query)
                _drinks.postValue(handleResponse(response))
            }else{
                _drinks.postValue(Resource.Error("Please connect to Internet"))
            }
        }
    }

    fun updateDrinkDetail(drink: Drink){
        drinkDetailItem = drink
    }



    private fun handleResponse(response : Response<DrinksResponse>) : Resource<DrinksResponse> {
        if(response.isSuccessful){
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }




    @SuppressLint("StaticFieldLeak")
    private val context = getApplication<Application>().applicationContext

    ///for internet check
    private fun isNetworkAvailable(): Boolean {

        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false
    }
}