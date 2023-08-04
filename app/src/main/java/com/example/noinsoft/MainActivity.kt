package com.example.noinsoft

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.noinsoft.navigation.SetUpNavGraph

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            navController = rememberNavController()
            SetUpNavGraph(navHostController = navController)

//            LoginScreen()
//            PassCodeView()
//            ManScreen()
        }
    }
}


