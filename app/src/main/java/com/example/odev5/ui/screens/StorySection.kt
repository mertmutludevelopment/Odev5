package com.example.odev5.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.odev5.R
import androidx.compose.material.icons.outlined.Star




@Composable
fun StorySection() {
    val stories = listOf(
        "Size Özel" to R.drawable.gift_svgrepo_com__4_,
        "Akıllı Cihazım" to R.drawable.wifi_1_svgrepo_com,
        "Togg Sigorta" to R.drawable.protection_secure_security_svgrepo_com,
        "1.5 Yenilikleri" to R.drawable.update_svgrepo_com,
        "Go.more" to R.drawable.navigation_svgrepo_com,
        "Play.more" to R.drawable.play_svgrepo_com,
        "T10X'inle Mil Kazan!" to R.drawable.plane_svgrepo_com
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding( horizontal = 10.dp, vertical = 0.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(stories) { index, story ->
            val borderBrush = if ((index / 2) % 2 == 0) {
                Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFFDCB68),
                        Color(0xFFCA2A74),
                        Color(0xFF9732B8)
                    )
                )
            } else {
                Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF7455FD),
                        Color(0xFF16CADD),
                        Color(0xFF438FF8)
                    )
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(72.dp)
            ) {

                Box(
                    modifier = Modifier.size(60.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .background(Color.Transparent, shape = RoundedCornerShape(50))
                            .border(
                                width = 1.75.dp,
                                brush = borderBrush,
                                shape = RoundedCornerShape(50)
                            )
                    )
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(52.dp)
                            .background(Color(0xFF0173D6), shape = RoundedCornerShape(50))
                    ) {
                        Image(
                            painter = painterResource(id = story.second),
                            contentDescription = story.first,
                            modifier = Modifier.size(36.dp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(20.dp)
                            .background(Color(0xFFFFA500), shape = RoundedCornerShape(50))
                            .offset(x = 0.dp, y = (-2).dp),
                            contentAlignment = Alignment.Center

                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Star,
                            contentDescription = "Star Icon",
                            modifier = Modifier.size(12.dp),
                            tint = Color.White
                        )
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = story.first,
                    fontSize = 12.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    maxLines = 2 ,
                    lineHeight = 12.sp

                )
            }
        }
    }
}
