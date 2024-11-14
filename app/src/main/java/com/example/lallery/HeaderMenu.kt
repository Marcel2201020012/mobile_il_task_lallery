package com.example.lallery

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lallery.navigations.NavigationRoutes

@Composable
fun HeaderMenuScreen(showBackButton: Boolean, title: String, id: String?, navController: NavController) {

    val headerArrangemnet by remember {
        mutableStateOf(Arrangement.SpaceEvenly)
    }

    var header = headerArrangemnet
    if(showBackButton) header = Arrangement.SpaceBetween

    Box(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
            .height(80.dp)
            .background(color = Color(0xFF7CBEF0)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = header,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            if(
                showBackButton
            ) {
                IconButton(onClick = {
                    id?.let{
                    if (id.contains('a') or id.contains('b')){
                        navController.navigate(NavigationRoutes.screen1){
                            popUpTo(NavigationRoutes.detailColumn){
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }
                    else
                        navController.navigate(NavigationRoutes.screen2){
                            popUpTo(NavigationRoutes.detailColumn){
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "back icon",
                        tint = Color.White
                    )
                }
            }

            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.White,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            if(showBackButton) {
                Spacer(Modifier.width(32.dp))
            }
        }
    }
}

@Preview
@Composable
fun TestHeaderMenuScreen() {
    HeaderMenuScreen(true, "test", id = null, rememberNavController())
}