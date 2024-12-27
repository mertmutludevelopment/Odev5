package com.example.odev5.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kisileruygulamasi.ui.screen.Anasayfa

@Composable
fun SayfaGecisleri(){

    val navController = rememberNavController()

    NavHost(navController, startDestination = "anasayfa") {
        composable("anasayfa"){
            Anasayfa()
        }
    }

}