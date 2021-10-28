package com.ysanjeet535.drinksapp.view.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.ysanjeet535.drinksapp.data.remote.dto.Drink
import com.ysanjeet535.drinksapp.view.viewmodel.MainViewModel

@Composable
fun DetailScreenContent(mainViewModel: MainViewModel){
    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()
        ) {
        val drink = mainViewModel.drinkDetailItem
        Box(modifier= Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
            .clip(RoundedCornerShape(8.dp))){
            Image(
                painter = rememberImagePainter(data = drink.strDrinkThumb),
                contentDescription = "drink thumb",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Column {
            Text(text = drink.strDrink,style = MaterialTheme.typography.h1)
            Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = drink.strCategory,style = MaterialTheme.typography.h4)
                Text(text = drink.strAlcoholic,style = MaterialTheme.typography.h4)
                Text(text = drink.strGlass,style = MaterialTheme.typography.h4)
            }
            Text(text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
                    append("Instruction :")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.Light)){
                    append(drink.strInstructions)
                }
            })

            Divider()

            Text(text = "Ingredients",style = MaterialTheme.typography.h4)
            IngredientsRow(item = drink)

        }

    }
}

@Composable
fun IngredientsRow(item : Drink){
    Column {
        if(item.strIngredient1 != null) {
            Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "${item.strIngredient1}")
                Text(text = "${item.strMeasure1}")
            }
        }

        if(item.strIngredient2 != null) {
            Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "${item.strIngredient2}")
                Text(text = "${item.strMeasure2}")
            }
        }

        if(item.strIngredient3 != null) {
            Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "${item.strIngredient3}")
                Text(text = "${item.strMeasure3}")
            }
        }

        if(item.strIngredient4 != null) {
            Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "${item.strIngredient4}")
                Text(text = "${item.strMeasure4}")
            }
        }

        if(item.strIngredient5 != null){
            Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "${item.strIngredient5}")
                Text(text = "${item.strMeasure5}")
            }
        }


    }


}