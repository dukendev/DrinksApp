package com.ysanjeet535.drinksapp.view.home

import android.os.Bundle
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ysanjeet535.drinksapp.data.remote.dto.Drink
import com.ysanjeet535.drinksapp.view.viewmodel.MainViewModel

@ExperimentalFoundationApi
@Composable
fun FoodGrid(drinksList : List<Drink>,navController: NavController,mainViewModel: MainViewModel){
    LazyVerticalGrid(cells = GridCells.Fixed(2)){
        items(drinksList){ drink ->
            val onCardClicked : (Drink)->Unit = {
                mainViewModel.updateDrinkDetail(drink)
                navController.navigate("detail")
            }
            FoodCard(drink = drink,onCardClicked)
        }
    }
}