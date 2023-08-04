package com.example.noinsoft.navigation

sealed class Screen(val route: String) {
    object Login : Screen(route = "login_screen")
    object PassCode : Screen(route = "pass_code_screen")
    object Home : Screen(route = "home_screen")
}
