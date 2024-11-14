package com.example.lallery

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lallery.navigations.NavigationRoutes

@Composable
fun LalleryApp() {

    Box(modifier = Modifier.fillMaxSize()) {
        val navController = rememberNavController()
        val currentBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = currentBackStackEntry?.destination?.route
        var showFooter by remember {
            mutableStateOf(false)
        }

        NavHost(
            navController = navController,
            startDestination = NavigationRoutes.screen1,
            builder = {
                composable(NavigationRoutes.screen1) {
                    Screen1Page(navController, currentRoute)
                    showFooter = true
                }
                composable(NavigationRoutes.screen2) {
                    Screen2Page(currentRoute, navController)
                    showFooter = true
                }
                composable(NavigationRoutes.screen3) {
                    Screen3Page(currentRoute, navController)
                    showFooter = true
                }
                composable(NavigationRoutes.detailColumn){
                    val itemId = currentBackStackEntry?.arguments?.getString("itemId") ?: ""
                    DetailPageScreen(itemId, navController)
                    showFooter = false
                }
            }
        )

        if (showFooter) {
            FooterMenuDesign(Modifier.align(Alignment.BottomCenter), navController, currentRoute)
        }
    }
}

@Preview
@Composable
fun TestLalleryApp() {

}