package com.example.noinsoft.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.noinsoft.screens.LoginScreen
import com.example.noinsoft.screens.ManScreen
import com.example.noinsoft.screens.PassCodeView

@Composable
fun SetUpNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screen.Login.route) {
        composable(route = Screen.Login.route) {
            LoginScreen(navHostController)
        }
        composable(route = Screen.PassCode.route) {
            PassCodeView(navHostController)
        }
        composable(route = Screen.Home.route) {
            ManScreen()
        }
    }
}