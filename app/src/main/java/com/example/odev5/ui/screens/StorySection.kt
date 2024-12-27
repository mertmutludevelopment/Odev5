package com.example.odev5.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.odev5.R
import androidx.compose.material.icons.outlined.Star
import androidx.compose.ui.zIndex




@Composable
fun StorySection() {
    // Story listesi
    val stories = listOf(
        "Size Özel" to R.drawable.gift_svgrepo_com__4_, // Özel ikon ve metin
        "Akıllı Cihazım" to R.drawable.wifi_1_svgrepo_com,
        "Togg Sigorta" to R.drawable.protection_secure_security_svgrepo_com,
        "1.5 Yenilikleri" to R.drawable.update_svgrepo_com,
        "Go.more" to R.drawable.navigation_svgrepo_com,
        "Play.more" to R.drawable.play_svgrepo_com // Ekstra story
    )
    val backgroundColor = Color(0xFF0173D6)

    // Scrollable LazyRow
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding( horizontal = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp) // Öğeler arasındaki boşluk
    ) {
        itemsIndexed(stories) { index, story -> // `itemsIndexed` ile index alınıyor
            // Border rengi dinamik olarak belirleniyor
            val borderBrush = if ((index / 2) % 2 == 0) {
                Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFFDCB68),
                        Color(0xFFCA2A74),
                        Color(0xFF9732B8)
                    )
                ) // Gradient renkler
            } else {
                Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF7455FD),
                        Color(0xFF16CADD),
                        Color(0xFF438FF8)
                    )
                ) // Gradient renkler
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(72.dp) // Her bir öğe genişliği
            ) {
                // Border ve içerik yapısı
                Box(
                    modifier = Modifier.size(60.dp), // Border boyutu
                    contentAlignment = Alignment.Center
                ) {
                    // Border
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .background(Color.Transparent, shape = RoundedCornerShape(50)) // Şeffaf arka plan
                            .border(
                                width = 1.75.dp, // Border genişliği
                                brush = borderBrush, // Dinamik border rengi
                                shape = RoundedCornerShape(50) // Yuvarlak border
                            )
                    )
                    // İçerik
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(52.dp) // İçerik boyutu (borderdan küçük)
                            .background(Color(0xFF0173D6), shape = RoundedCornerShape(50)) // İçerik arka planı
                    ) {
                        Image(
                            painter = painterResource(id = story.second), // İkon kaynağı
                            contentDescription = story.first,
                            modifier = Modifier.size(36.dp) // İkon boyutu
                        )
                    }
                    // Yıldız İkonu
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd) // Sağ alt köşe hizalama
                            .size(20.dp) // Kutunun boyutu
                            .background(Color(0xFFFFA500), shape = RoundedCornerShape(50)) // Turkuaz arka plan
                            .offset(x = 0.dp, y = (-2).dp), // Çerçevenin üstüne taşması için offset
                            contentAlignment = Alignment.Center

                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Star, // Material Design Star ikonu
                            contentDescription = "Star Icon",
                            modifier = Modifier.size(12.dp), // İkon boyutu
                            tint = Color.White // İkon rengi (Beyaz)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(4.dp)) // İkon ile metin arası boşluk
                Text(
                    text = story.first,
                    fontSize = 12.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    maxLines = 2 ,// Metin iki satırda sınırlı
                    lineHeight = 12.sp

                )
            }
        }
    }
}
