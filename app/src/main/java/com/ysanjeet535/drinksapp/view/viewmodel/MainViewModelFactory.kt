package com.ysanjeet535.drinksapp.view.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ysanjeet535.drinksapp.data.DrinksRepository

class MainViewModelFactory(private val app: Application,private val repository: DrinksRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository = repository,application = app) as T
    }
}