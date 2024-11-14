package com.example.lallery.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lallery.R
import com.example.lallery.model.LazyColumnModel
import com.example.lallery.navigations.NavigationRoutes

@Composable
fun LazyColumnCardDesign(item: LazyColumnModel, navController: NavController) {
    Box(
        Modifier
            .clip(RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .height(82.dp)
            .background(color = Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Box(
            Modifier
                .clip(RoundedCornerShape(20.dp))
                .fillMaxWidth()
                .padding(horizontal = 2.dp)
                .height(80.dp)
                .background(color = Color.White)
                .clickable {
                           navController.navigate("DetailPageLazyColumn/${item.id}")
                },
            contentAlignment = Alignment.Center
        ) {
            Row(
                Modifier.padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Image(painter = painterResource(item.img), contentDescription = "logo pt",
                    Modifier.size(80.dp))
                Column {
                    Text(text = item.pt,
                        style = MaterialTheme.typography.bodyLarge)
                    Text(text = item.desc,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis)
                }
            }
        }
    }
}

@Composable
fun LazyColumnGenerator(cardItem: List<LazyColumnModel>, navController: NavController) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)){
        items(cardItem){item ->
            LazyColumnCardDesign(item, navController)
        }
    }
}


@Preview
@Composable
fun TestLazyColumnCardDesign() {
    LazyColumnCardDesign(
        LazyColumnModel(
            "1",
            "Axioo",
            R.drawable.logo_axioo,
            "Axioo (ditulis axioo) adalah salah satu perusahaan elektronik di Indonesia yang memproduksi atau menyediakan komputer, laptop, ponsel cerdas, komputer tablet, dan sebagainya."
        ),
        rememberNavController()
    )
}