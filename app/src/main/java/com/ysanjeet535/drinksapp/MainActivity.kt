package com.ysanjeet535.drinksapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ysanjeet535.drinksapp.data.remote.DrinksApi
import com.ysanjeet535.drinksapp.data.remote.dto.Drink
import com.ysanjeet535.drinksapp.ui.theme.DrinksAppTheme
import com.ysanjeet535.drinksapp.view.detail.DetailScreenContent
import com.ysanjeet535.drinksapp.view.home.FoodCard
import com.ysanjeet535.drinksapp.view.home.HomeScreenContent
import com.ysanjeet535.drinksapp.view.viewmodel.MainViewModel
import com.ysanjeet535.drinksapp.view.viewmodel.MainViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @ExperimentalAnimationApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val viewModel by viewModels<MainViewModel>()
        setContent {
            DrinksAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController,startDestination = "home"){
                        composable("home"){
                            HomeScreenContent(mainViewModel = viewModel,navController= navController)
                        }
                        composable(
                            "detail"
                        ){
                            DetailScreenContent(mainViewModel = viewModel)
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DrinksAppTheme {

    }
}