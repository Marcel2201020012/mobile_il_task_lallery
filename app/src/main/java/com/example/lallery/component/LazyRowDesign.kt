package com.example.lallery.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
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
import com.example.lallery.model.LazyRowModel

@Composable
fun LazyRowCardDesign(item: LazyRowModel, navController: NavController) {
    Box(
        Modifier
            .clip(RoundedCornerShape(8.dp))
            .size(82.dp)
            .background(color = Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Box(
            Modifier
                .clip(RoundedCornerShape(8.dp))
                .size(80.dp)
                .background(color = Color.White)
                .clickable {
                    navController.navigate("DetailPageLazyColumn/${item.id}")
                },
            contentAlignment = Alignment.Center
        ) {
            Column(
                Modifier.padding(start = 4.dp, end = 4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Image(
                    painter = painterResource(id = item.img),
                    contentDescription = "gambar",
                    Modifier.size(48.dp)
                )
                Text(
                    text = item.nama,
                    style = MaterialTheme.typography.bodyLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun LazyRowGenerator(cardItem: List<LazyRowModel>, navController: NavController) {
    LazyRow(Modifier.padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(cardItem) { item ->
            LazyRowCardDesign(item, navController)
        }
    }
}

@Preview
@Composable
fun TestLazyRowCardDesign() {
    LazyRowCardDesign(
        LazyRowModel(
            "a1",
            "Axioo z6",
            R.drawable.axioo_z6,
            "Axioo Mybook Z6 METAL\n" +
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
                    "Memory RAM 8GB (2x SODIMM DDR4 Up to 64GB dual channel,Frequency Up to 3200MHz)\n" +
                    "Storage 1x 256GB M.2 2280 NVMe PCIe Gen. 3x4 (Upgradeable Up to 2TB PCle Gen. 4x4)\n" +
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