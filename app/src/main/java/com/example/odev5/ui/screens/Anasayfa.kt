package com.example.kisileruygulamasi.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ElectricCar
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.AccountBalanceWallet
import androidx.compose.material.icons.outlined.MoreHoriz
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.odev5.R
import com.example.odev5.ui.screens.CardSection
import com.example.odev5.ui.screens.StorySection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa() {
    // Seçili sekmeyi kontrol eden state
    val imageList = listOf(
        R.drawable.card1,
        R.drawable.card2,
        R.drawable.card3 ,
        R.drawable.card4,
        R.drawable.card5,
        R.drawable.card6
    )
    var selectedItem by remember { mutableStateOf(0) }

    // Turkuaz renk
    val Turquoise = Color(0xFF02C1E6) // RGB renk kodu

    // Bottom Navigation Bar için item listesi
    val items = listOf(
        "Anasayfa" to Icons.Outlined.Home,
        "Akıllı Cihazım" to Icons.Outlined.ElectricCar,
        "Gez" to Icons.Outlined.LocationOn,
        "Kazan" to Icons.Outlined.AccountBalanceWallet,
        "Fazlası" to Icons.Outlined.MoreHoriz
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    // Sol tarafta Togg logosu
                    Image(
                        painter = painterResource(id = R.drawable.truemore_logo), // Logonun kaynağı
                        contentDescription = "Togg Logo",
                        modifier = Modifier
                            .size(120.dp) // Logonun boyutu
                            .padding(start = 8.dp),
                        contentScale = ContentScale.Fit
                    )
                },
                title = { Spacer(modifier = Modifier) }, // Boş bir başlık veriyoruz
                actions = {
                    Row {
                        IconButton(onClick = { /* Alışveriş tıklama işlemi */ }) {
                            Icon(
                                imageVector = Icons.Outlined.ShoppingBag, // Alışveriş ikonu
                                contentDescription = "Shopping Bag Icon",
                                modifier = Modifier.size(28.dp), // İkon boyutu
                                tint = Turquoise // İkon rengi
                            )
                        }
                        IconButton(onClick = { /* Bildirim tıklama işlemi */ }) {
                            Icon(
                                imageVector = Icons.Outlined.Notifications, // Bildirim ikonu
                                contentDescription = "Notifications Icon",
                                modifier = Modifier.size(28.dp), // İkon boyutu
                                tint = Turquoise // İkon rengi
                            )
                        }
                        IconButton(onClick = { /* Tıklama işlemi */ }) {
                            Icon(
                                imageVector = Icons.Outlined.Person, // Material Design Person ikonu
                                contentDescription = "Profil İkonu",
                                modifier = Modifier.size(28.dp), // İkon boyutu
                                tint = Color.Black // İkon rengi
                            )
                        }
                    }

                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFFF8F8F8) // TopBar arka plan rengi
                )
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFFF8F8F8) // Alt çubuğun arka plan rengi
            ) {
                items.forEachIndexed { index, item ->
                    // Her öğe için NavigationBarItem çağrılır
                    NavigationBarItem(
                        selected = selectedItem == index,
                        onClick = { selectedItem = index },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Turquoise, // Seçili ikon rengi turkuaz
                            selectedTextColor = Turquoise, // Seçili metin rengi turkuaz
                            unselectedIconColor = Color.Gray, // Seçili olmayan ikon rengi
                            unselectedTextColor = Color.Gray, // Seçili olmayan metin rengi
                            indicatorColor = Color.Transparent
                        ),
                        label = {
                            Text(
                                text = item.first,
                                textAlign = TextAlign.Center, // Metni ortala
                                fontSize = 10.sp, // Yazı boyutu
                                maxLines = 1
                            )
                        },
                        icon = {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                if (selectedItem == index) {
                                    Box(
                                        modifier = Modifier
                                            .height(3.dp) // Çizginin yüksekliği
                                            .fillMaxWidth(0.4f) // Çizginin genişliği
                                            .background(
                                                color = Turquoise,
                                                shape = RoundedCornerShape(50) // Köşeleri yuvarla
                                            )
                                    )
                                }
                                Icon(
                                    imageVector = item.second,
                                    contentDescription = item.first,
                                    modifier = Modifier.size(28.dp) // İkon boyutu
                                )
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        // Anasayfa içeriği
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            StorySection()
            Spacer(modifier = Modifier.height(8.dp))
            CardSection(imageList = imageList)
        }
    }
}
