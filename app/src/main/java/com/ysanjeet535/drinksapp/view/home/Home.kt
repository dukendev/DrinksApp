package com.ysanjeet535.drinksapp.view.home

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.ysanjeet535.drinksapp.data.remote.dto.DrinksResponse
import com.ysanjeet535.drinksapp.utils.Resource
import com.ysanjeet535.drinksapp.view.viewmodel.MainViewModel

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun HomeScreenContent(navController: NavController,mainViewModel: MainViewModel,state: SearchState = rememberSearchState()){

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()) {
        WelcomeText()
        SearchBar(
            query = state.query,
            onQueryChange = {state.query = it},
            onSearchFocusChange = {state.focused = it},
            onClearQuery =  { state.query = TextFieldValue("") } ,
            onBack = { state.query = TextFieldValue("") },
            searching = state.searching,
            focused = state.focused
        )
        //this val will be used by view model
        val searchQueryParam = state.query.text
        Log.d("QUERY",searchQueryParam)
        LaunchedEffect(key1 = searchQueryParam){
            mainViewModel.getDrinks(searchQueryParam)
        }
        NearRestaurantContent()
        val drinks by mainViewModel.drinks.observeAsState()
        when(drinks){
            is Resource.Success -> {
                val drinksList = (drinks as Resource.Success<DrinksResponse>).data?.drinks
                if (drinksList != null) {
                    FoodGrid(drinksList,navController,mainViewModel)
                }
            }
            is Resource.Error -> {
                Text(text = "Error of type ${(drinks as Resource.Error<DrinksResponse>).data.toString()}")
            }
            is Resource.Loading -> {
                CircularProgressIndicator()
            }
        }

    }
}

@Composable
fun WelcomeText(){
    Box(modifier = Modifier
        .padding(vertical = 32.dp)
        .fillMaxWidth()) {
        Text(text = "Let's Drink Quality Cocktail",style = MaterialTheme.typography.h1)
    }
}

