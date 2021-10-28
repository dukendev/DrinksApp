package com.ysanjeet535.drinksapp.view.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun NearRestaurantContent(){
    Column {
        NearRestaurant()
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.White)
                .clickable {
                    //open details screen from here
                    //
                },
            elevation = 8.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxHeight()
                        .fillMaxWidth(0.5f)
                        .clip(RoundedCornerShape(8.dp))
                ) {
                    Image(
                        painter = rememberImagePainter(
                            data = "https://images.unsplash.com/photo-1590846406792-0adc7f938f1d?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1885&q=80"),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                Column(modifier = Modifier.padding(8.dp),verticalArrangement = Arrangement.Center) {
                    Text(text = "Blue Restaurant",style = MaterialTheme.typography.h4)
                    Text(text = "10:00 AM-09:00 PM",style = MaterialTheme.typography.h5)

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Steve ST Road",style = MaterialTheme.typography.h6)
                        Row(horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "4.5",
                                style = MaterialTheme.typography.h6,
                                modifier = Modifier.padding(vertical = 2.dp, horizontal = 4.dp)
                            )
                            Icon(Icons.Default.Star, contentDescription = "star",tint = Color(0xffFEE440))
                        }
                    }
                }



            }
        }
    }
}

@Composable
fun NearRestaurant(){
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Near Restaurants",style = MaterialTheme.typography.h2)
        Text(text = "See All",style = MaterialTheme.typography.h4,modifier = Modifier.clickable {  })
    }
}