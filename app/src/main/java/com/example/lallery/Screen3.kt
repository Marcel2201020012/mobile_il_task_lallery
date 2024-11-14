package com.example.lallery

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Screen3Page(currentRoute: String?, navController: NavController) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        HeaderMenuScreen(showBackButton = false, title = "Profile", currentRoute, navController)

        Box(
            Modifier
                .fillMaxSize()
                .padding(start = 12.dp, end = 12.dp, bottom = 60.dp)
                .background(
                    Color.White,
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                )
        ) {
            Column(
                Modifier.fillMaxSize()
            ) {
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.profile_image),
                        contentDescription = "profil image",
                        Modifier.clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    )
                    Text(
                        text = "Marcel Wangnandra",
                        Modifier
                            .align(Alignment.BottomStart)
                            .padding(8.dp),
                        style = MaterialTheme.typography.titleLarge
                    )
                }

                Column(
                    Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Divider()
                    Text(
                        text = "Email:\nmarcelaja314@gmail.com",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Divider()
                    Text(
                        text = "Asal Perguruan Tinggi:\nUniversitas Maritim Raja Ali Haji",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Divider()
                    Text(
                        text = "Jurusan:\nTeknik Informatika",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Divider()
                }

            }
        }
    }
}

@Preview
@Composable
fun TestScreen3Page() {
    Box {
        Screen3Page(currentRoute = null, rememberNavController())
        FooterMenuDesign(modifier = Modifier.align(Alignment.BottomCenter), rememberNavController(), null)
    }
}