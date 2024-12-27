package com.example.kisileruygulamasi.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
    val imageList = listOf(
        R.drawable.card1,
        R.drawable.card2,
        R.drawable.card3 ,
        R.drawable.card4,
        R.drawable.card5,
        R.drawable.card6
    )
    var selectedItem by remember { mutableStateOf(0) }

    val Turquoise = Color(0xFF02C1E6)
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
                    Image(
                        painter = painterResource(id = R.drawable.truemore_logo),
                        contentDescription = "Togg Logo",
                        modifier = Modifier
                            .size(120.dp)
                            .padding(start = 8.dp),
                        contentScale = ContentScale.Fit
                    )
                },
                title = { Spacer(modifier = Modifier) },
                actions = {
                    Row {
                        IconButton(onClick = {  }) {
                            Icon(
                                imageVector = Icons.Outlined.ShoppingBag,
                                contentDescription = "Shopping Bag Icon",
                                modifier = Modifier.size(28.dp),
                                tint = Turquoise
                            )
                        }
                        IconButton(onClick = {  }) {
                            Icon(
                                imageVector = Icons.Outlined.Notifications,
                                contentDescription = "Notifications Icon",
                                modifier = Modifier.size(28.dp),
                                tint = Turquoise
                            )
                        }
                        IconButton(onClick = {  }) {
                            Icon(
                                imageVector = Icons.Outlined.Person,
                                contentDescription = "Profil İkonu",
                                modifier = Modifier.size(28.dp),
                                tint = Color.Black
                            )
                        }
                    }

                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFFFAFAFA)
                )
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFFFAFAFA)
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItem == index,
                        onClick = { selectedItem = index },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Turquoise,
                            selectedTextColor = Turquoise,
                            unselectedIconColor = Color.Gray,
                            unselectedTextColor = Color.Gray,
                            indicatorColor = Color.Transparent
                        ),
                        label = {
                            Text(
                                text = item.first,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp,
                                maxLines = 1
                            )
                        },
                        icon = {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                if (selectedItem == index) {
                                    Box(
                                        modifier = Modifier
                                            .height(3.dp)
                                            .fillMaxWidth(0.4f)
                                            .background(
                                                color = Turquoise,
                                                shape = RoundedCornerShape(50)
                                            )
                                    )
                                }
                                Icon(
                                    imageVector = item.second,
                                    contentDescription = item.first,
                                    modifier = Modifier.size(28.dp)
                                )
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFFFAFAFA))
        ) {
            StorySection()
            Spacer(modifier = Modifier.height(8.dp))
            CardSection(imageList = imageList)
        }
    }
}
