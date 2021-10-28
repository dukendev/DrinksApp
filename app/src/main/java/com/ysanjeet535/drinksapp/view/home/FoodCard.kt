package com.ysanjeet535.drinksapp.view.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.ysanjeet535.drinksapp.data.remote.dto.Drink

@Composable
fun FoodCard(drink: Drink, onCardClicked : (Drink)->Unit = {}){
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(0.5f)
            .height(250.dp)
            .background(Color.White)
            .clickable {
                //open details screen from here
                onCardClicked(drink)
            },
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.6f)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = drink.strDrinkThumb),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Column(modifier = Modifier.padding(8.dp),verticalArrangement = Arrangement.Center) {
                Text(text = drink.strDrink,style = MaterialTheme.typography.h4)
                Text(text = "${drink.strCategory}/${drink.strAlcoholic}",style = MaterialTheme.typography.h5)
            }

            Row(
                modifier = Modifier.padding(8.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "$10",style = MaterialTheme.typography.h6)
                Box(modifier = Modifier
                    .border(BorderStroke(1.dp, Color.Red))
                    .clickable { }
                ) {
                    Text(
                        text = "View",
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(vertical = 2.dp, horizontal = 4.dp)
                    )
                }
            }

        }
    }
}