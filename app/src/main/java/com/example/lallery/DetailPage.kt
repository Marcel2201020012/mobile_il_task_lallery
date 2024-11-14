package com.example.lallery

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lallery.component.formatHarga
import com.example.lallery.data.TestData.lazyColumData
import com.example.lallery.data.TestData.lazyRowData
import com.example.lallery.data.TestData.lazyGridData


@Composable
fun DetailPageScreen(id: String, navController: NavController) {
    if (id.contains('a')) RowDetailDesign(id, navController)
    else if (id.contains('b')) ColumnDetailDesign(id, navController)
    else GridDetailDesign(id, navController)
}

@Composable
fun RowDetailDesign(id: String, navController: NavController) {
    val item = lazyRowData.find { it.id == id }

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item?.let {
            HeaderMenuScreen(showBackButton = true, title = item.nama, id, navController)

            Box(
                Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    Modifier.padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    Box(
                        Modifier
                            .fillMaxWidth()
                            .background(
                                Color(0xFFC6DDE8),
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(item.img),
                            contentDescription = item.nama,
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .verticalScroll(rememberScrollState())
                    ) {
                        Text(
                            text = item.desc,
                            style = MaterialTheme.typography.bodySmall.copy(
                                textAlign = TextAlign.Justify,
                                fontSize = 12.sp
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ColumnDetailDesign(id: String, navController: NavController) {
    val item = lazyColumData.find { it.id == id }

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item?.let {
            HeaderMenuScreen(showBackButton = true, title = item.pt, id, navController)

            Box(
                Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    Modifier.padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    Box(
                        Modifier
                            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                            .fillMaxWidth()
                            .background(
                                Color(0xFFC6DDE8),
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(item.img),
                            contentDescription = item.pt,
                            Modifier
                                .size(120.dp)
                                .clip(RoundedCornerShape(16.dp))
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .verticalScroll(rememberScrollState())
                    ) {
                        Text(
                            text = item.desc,
                            style = MaterialTheme.typography.bodySmall.copy(
                                textAlign = TextAlign.Justify,
                                fontSize = 12.sp
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun GridDetailDesign(id: String, navController: NavController) {
    val context = LocalContext.current

    val item = lazyGridData.find { it.id == id }

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item?.let {
            HeaderMenuScreen(showBackButton = true, title = item.nama, id, navController)

            Box(
                Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    Modifier.padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    Box(
                        Modifier
                            .fillMaxWidth()
                            .background(
                                Color(0xFFC6DDE8),
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(item.img),
                            contentDescription = item.nama,
                        )
                    }

                    Text(
                        text = formatHarga(item.harga),
                        style = MaterialTheme.typography.bodyMedium.copy(fontSize = 20.sp)
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .verticalScroll(rememberScrollState())
                    ) {
                        Text(
                            text = item.spec,
                            style = MaterialTheme.typography.bodySmall.copy(
                                textAlign = TextAlign.Justify,
                                fontSize = 12.sp
                            )
                        )
                    }

                    Button(
                        onClick = {
                            Toast.makeText(context, "Terima Kasih!", Toast.LENGTH_SHORT).show()
                        },
                        Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Beli")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestDetailPage() {
    GridDetailDesign("c2", rememberNavController())
}