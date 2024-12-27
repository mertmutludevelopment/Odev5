package com.example.odev5.ui.screens



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun CardSection(imageList: List<Int>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp)
    ) {
        items(imageList.size) { index ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(480.dp)
                    .padding(vertical = 8.dp, horizontal = 32.dp)
            ) {
                Image(
                    painter = painterResource(id = imageList[index]),
                    contentDescription = "Card Image $index",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}
