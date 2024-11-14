package com.example.lallery

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lallery.navigations.NavigationRoutes

@Composable
fun FooterMenuDesign(
    modifier: Modifier = Modifier,
    navController: NavController,
    currentRoute: String?
) {

    //state
    val produkButtonIsClicked = currentRoute == NavigationRoutes.screen1
    val shoppingButtonIsClicked = currentRoute == NavigationRoutes.screen2
    val profilIsClicked = currentRoute == NavigationRoutes.screen3

    val produkIcon =
        if (produkButtonIsClicked) R.drawable.produk_icon_active else R.drawable.produk_icon
    val shoppingIcon =
        if (shoppingButtonIsClicked) R.drawable.cart_icon_active else R.drawable.cart_icon
    val profilIcon =
        if (profilIsClicked) R.drawable.profil_icon_active else R.drawable.profile_icon

    Box(
        modifier = modifier
            .height(62.dp)
            .background(
                color = Color.LightGray, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            ), contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            Modifier
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .fillMaxWidth()
                .height(60.dp)
                .background(color = Color.White),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    navController.navigate(NavigationRoutes.screen1) {
                        popUpTo(0) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }) {
                    Icon(
                        painter = painterResource(produkIcon),
                        contentDescription = "logo screen1",
                        tint = Color.Unspecified
                    )
                }
                IconButton(onClick = {
                    navController.navigate(NavigationRoutes.screen2) {
                        popUpTo(NavigationRoutes.screen2) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }) {
                    Icon(
                        painter = painterResource(shoppingIcon),
                        contentDescription = "logo screen2",
                        tint = Color.Unspecified
                    )
                }
                IconButton(onClick = {
                    navController.navigate(NavigationRoutes.screen3) {
                        popUpTo(NavigationRoutes.screen3) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }) {
                    Icon(
                        painter = painterResource(profilIcon),
                        contentDescription = "logo screen3",
                        tint = Color.Unspecified
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TestFooterMenuDesign() {
    Box{
        FooterMenuDesign(modifier = Modifier, rememberNavController(), currentRoute = null)
    }
}