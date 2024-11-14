package com.example.lallery

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lallery.component.LazyColumnGenerator
import com.example.lallery.component.LazyRowGenerator
import com.example.lallery.data.TestData.lazyColumData
import com.example.lallery.data.TestData.lazyRowData

@Composable
fun Screen1Page(navController: NavController, currentRoute: String?) {
    //Top Bar
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        HeaderMenuScreen(showBackButton = false, "Lallery", currentRoute, navController)

        //konten
        Column(
            Modifier.padding(top = 12.dp, start = 12.dp, end = 12.dp, bottom = 50.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //lazyRow
            Text(text = "Laptop Berkelas")
            LazyRowGenerator(lazyRowData, navController)

            Divider(Modifier.fillMaxWidth())

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Perusahaan Laptop Berkelas")
                Text(text = "")
            }
            //lazy column
            LazyColumnGenerator(lazyColumData, navController)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun TestScren1Page() {
    Box {
        Screen1Page(rememberNavController(), currentRoute = null)
        FooterMenuDesign(modifier = Modifier.align(Alignment.BottomCenter), rememberNavController(), null)
    }
}