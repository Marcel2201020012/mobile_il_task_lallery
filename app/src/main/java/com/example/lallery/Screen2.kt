package com.example.lallery

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lallery.component.LazyGridGenerator
import com.example.lallery.data.TestData.lazyGridData

@Composable
fun Screen2Page(currentRoute: String?, navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        HeaderMenuScreen(showBackButton = false, title = "Produk", currentRoute, navController)

        LazyGridGenerator(lazyGridData, navController)
    }
}

@Preview (showBackground = true)
@Composable
fun TestScreen2Page() {
   Box {
        Screen2Page(currentRoute = null, rememberNavController())
        FooterMenuDesign(Modifier.align(Alignment.BottomCenter), rememberNavController(), null)
    }
}