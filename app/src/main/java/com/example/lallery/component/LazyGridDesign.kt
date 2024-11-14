package com.example.lallery.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lallery.R
import com.example.lallery.model.LazyGridModel
import java.text.NumberFormat
import java.util.Locale

fun formatHarga(harga: Int): String {
    val formatter = NumberFormat.getNumberInstance(Locale("in", "ID"))
    val newHarga = formatter.format(harga)
    return "Rp.$newHarga"
}

@Composable
fun LazyGridDesign(item: LazyGridModel, navController: NavController) {
    Column(
        Modifier
            .width(80.dp)
            .clickable {
                navController.navigate("DetailPageLazyColumn/${item.id}")
            },
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Image(
            painter = painterResource(item.img), contentDescription = "foto",
        )
        Text(text = item.nama)
        Text(formatHarga(item.harga))
    }
}

@Composable
fun LazyGridGenerator(cardItem: List<LazyGridModel>, navController: NavController) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .padding(start = 12.dp, end = 12.dp, bottom = 50.dp)
    ) {
        items(cardItem) { item ->
            LazyGridDesign(item, navController)
        }
    }
}

@Preview
@Composable
fun TestLazyGridDesign() {
    LazyGridDesign(
        LazyGridModel(
            "c1",
            R.drawable.axioo_z6,
            "LAPTOP AXIOO MYBOOK Z6 i3 1215U 8GB 256SSD W11 14FHD",
            5450000,
            "Axioo Mybook Z6 \n" +
                    "Power Resilient Beauty\n" +
                    "\n" +
                    "Processor: Intel® Core™ i3-1215U Processor (6 Cores, 8 Threads, Base TDP: 15W)\n" +
                    "Performance Cores: 2 Cores, 4 Threads, 1.0 GHz Base, 4.4 GHz Turbo\n" +
                    "Efficient Cores: 4 Cores, 4 Threads, 0.7 GHz Base, 3.3 GHz Turbo\n" +
                    "Code Name Intel® Alder Lake\n" +
                    "Graphics Controller Intel® UHD Graphics for 12th Gen Intel® Processors\n" +
                    "LCD 14\" inch IPS (16:9)\n" +
                    "Display / Resolution FHD 1920x1080\n" +
                    "Support Windows® 11 (64-bit)\n" +
                    "\n" +
                    "Memory 8GB (RAM 2x SODIMM DDR4 Up to 64GB dual channel,Frequency Up to 3200MHz)\n" +
                    "Storage 256 M.2 NVMe PCIe Gen4x4\n" +
                    "Camera Front 2Mp\n" +
                    "Sound System HD Audio\n" +
                    "Built-in Microphone\n" +
                    "I/O Ports 1x USB 2.0 Type A port\n" +
                    "2x USB 3.0 Type A ports (1x With Power-off USB charging)\n" +
                    "1x USB 3.0 Type C port (Data Only)\n" +
                    "1x 3.5mm 2-in-1 Audio Combo Jack\n" +
                    "1x HDMI 1.4 output port\n" +
                    "1x RJ45 Gigabit LAN\n" +
                    "1x DC-in jack port\n" +
                    "1x SD Card Port (Up to 512GB)\n" +
                    "Power Management AC Adapter 19.0V/3.15A, 59.85W\n" +
                    "Embedded 3 cells Lithium-Ion battery pack,11.55V,55.20Wh,4780mAh\n" +
                    "Connection Intel AC-9560 ac/b/g/n\n" +
                    "Bluetooth 5.1\n" +
                    "Speaker 2x Speakers\n" +
                    "Security Kensington Lock\n" +
                    "TPM\n" +
                    "Bios AMI\n" +
                    "\n" +
                    "Dimension 323(W) x 221(D) x 18,9(H)mm\n" +
                    "weight 1,600g"
        ),
        rememberNavController()
    )
}