package com.example.noinsoft.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.noinsoft.R
import com.example.noinsoft.navigation.BottomBarScreen
import com.example.noinsoft.navigation.BottomNavGraph
import com.example.noinsoft.ui.theme.textBoldStyle
import com.example.noinsoft.ui.theme.textSmallStyle

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ManScreen() {

    val accountUserName = remember {
        mutableStateOf("Hello, Farrukh Yusupov")
    }

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navHostController = navController)
        }
    ) {
        BottomNavGraph(navController = navController)
    }

    Column(modifier = Modifier.padding(horizontal = 16.dp)) {

        Header(accountUserName = accountUserName, dayOfWeek = "Monday")
        StatusCard()

        Divider(
            modifier = Modifier.padding(vertical = 20.dp),
            color = Color.LightGray,
            thickness = 1.dp
        )

        TasksItem()

    }


}

@Composable
fun BottomBar(navHostController: NavHostController) {
    val screens = listOf(BottomBarScreen.Home)
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)

    BottomNavigation(
        backgroundColor = Color.Red,
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape)
            .height(80.dp),
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                curDestination = currentDestination,
                navController = navHostController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    curDestination: NavDestination?,
    navController: NavHostController,
) {
    BottomNavigationItem(modifier = Modifier.padding(bottom = 15.dp),
        label = {
            Text(
                text = screen.title,
                color = Color.White,
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.muller_medium))
            )
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Nav icon",
                tint = Color.White
            )
        },
        selected = curDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route)
        }
    )
}

@Composable
fun Header(accountUserName: MutableState<String>, dayOfWeek: String) {

    Row(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column {

            Row(verticalAlignment = Alignment.CenterVertically) {

                Image(
                    painter = painterResource(id = R.drawable.ic_weather_sunny),
                    contentDescription = null
                )

                Text(text = dayOfWeek, modifier = Modifier.padding(start = 5.dp))
            }

            Text(
                text = accountUserName.value,
                style = textBoldStyle,
                modifier = Modifier.padding(top = 5.dp)
            )

        }

        Image(
            painter = painterResource(id = R.drawable.ic_account_circle),
            contentDescription = null,
            modifier = Modifier
                .height(36.dp)
                .width(36.dp)
        )

    }

}

@Composable
fun StatusCard() {
    Surface(modifier = Modifier.fillMaxWidth()) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp),
            border = BorderStroke(1.dp, Color.LightGray),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent)
        ) {
            Column {
                Box(modifier = Modifier.padding(start = 32.dp, top = 32.dp)) {
                    Column {
                        Text(text = "All tasks", style = textSmallStyle)
                        Text(text = "0", style = textBoldStyle, fontSize = 32.sp)
                    }
                }

                Row(modifier = Modifier.padding(start = 32.dp, top = 20.dp, bottom = 32.dp)) {

                    Column {
                        Text(text = "All tasks", style = textSmallStyle)
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "0", style = textBoldStyle)
                            Image(
                                painter = painterResource(id = R.drawable.ic_main_green_arrow),
                                contentDescription = null,
                                modifier = Modifier.padding(start = 4.dp)
                            )
                        }
                    }

                    Column(modifier = Modifier.padding(start = 32.dp)) {
                        Text(text = "All tasks", style = textSmallStyle)
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "0", style = textBoldStyle)
                            Image(
                                painter = painterResource(id = R.drawable.ic_main_grey_arrow),
                                contentDescription = null,
                                modifier = Modifier.padding(start = 4.dp)
                            )
                        }
                    }

                }
            }
        }

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomEnd) {
            Image(
                painter = painterResource(id = R.drawable.image_2),
                contentDescription = null,
                modifier = Modifier
                    .width(194.dp)
                    .height(210.dp)
                    .offset(y = (-4).dp)
            )
        }

    }
}

@Composable
fun TasksItem() {
    Row {
        Text(text = "Tasks", style = textBoldStyle)
    }
}
