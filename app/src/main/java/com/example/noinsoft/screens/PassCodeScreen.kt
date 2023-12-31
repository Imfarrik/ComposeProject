package com.example.noinsoft.screens

import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.noinsoft.R
import com.example.noinsoft.navigation.Screen

@Composable
fun NumbersView(num1: String, num2: String, num3: String, isLast: Boolean = false) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                modifier = Modifier.padding(5.dp)
            ) {
                Text(
                    text = num1,
                    style = TextStyle(
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.muller_medium)),
                        fontSize = 24.sp
                    )
                )
            }
        }

        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
            Button(
                onClick = {
                    /*TODO*/
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                modifier = Modifier.padding(5.dp)
            ) {
                Text(
                    text = num2,
                    style = TextStyle(
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.muller_medium)),
                        fontSize = 24.sp
                    )
                )
            }
        }

        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                modifier = Modifier.padding(5.dp)
            ) {
                if (!isLast) {
                    Text(
                        text = num3,
                        style = TextStyle(
                            color = Color.Black,
                            fontFamily = FontFamily(Font(R.font.muller_medium)),
                            fontSize = 24.sp
                        )
                    )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.ic_clear),
                        contentDescription = "clean"
                    )
                }
            }

        }

    }
}

@Composable
fun PassCodeView(
    navController: NavController,
) {

    val oval: MutableState<Int> = remember {
        mutableStateOf(R.drawable.bg_pass_code_oval)
    }

    Image(
        painter = painterResource(id = R.drawable.splash_bg),
        contentDescription = "background image",
        modifier = Modifier.fillMaxSize()
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 32.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 48.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = R.drawable.splash_screen_logo),
                contentDescription = "logo"
            )

        }

        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Black)) {
                    append("Введите код,\nна смартфоне")
                }
            },
            modifier = Modifier
                .padding(top = 32.dp),
            style = TextStyle(
                fontSize = 28.sp,
                fontFamily = FontFamily(Font(R.font.muller_bold)),
                letterSpacing = 1.sp,
                lineHeight = 30.sp
            )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp)
        ) {
            Text(
                text = "Мы отправили на номер: ",
                style = TextStyle(color = Color.Gray)
            )
            Text(
                text = "",
                style = TextStyle(color = Color.Gray)
            )
        }

        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    Column {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 30.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            AndroidView(
                                modifier = Modifier.padding(end = 22.dp),
                                factory = {
                                    ImageView(it)
                                }
                            )
                            {
                                it.setImageResource(oval.value)
                            }
                            AndroidView(
                                modifier = Modifier.padding(end = 22.dp),
                                factory = {
                                    ImageView(it)
                                }
                            )
                            {
                                it.setImageResource(oval.value)
                            }
                            AndroidView(
                                modifier = Modifier.padding(end = 22.dp),
                                factory = {
                                    ImageView(it)
                                }
                            )
                            {
                                it.setImageResource(oval.value)
                            }
                            AndroidView(
                                modifier = Modifier.padding(end = 22.dp),
                                factory = {
                                    ImageView(it)
                                }
                            )
                            {
                                it.setImageResource(oval.value)
                            }
                            AndroidView(
                                factory = {
                                    ImageView(it)
                                }
                            )
                            {
                                it.setImageResource(oval.value)
                            }
                        }

                        NumbersView(num1 = "1", num2 = "2", num3 = "3")

                        NumbersView(num1 = "4", num2 = "5", num3 = "6")

                        NumbersView(num1 = "7", num2 = "8", num3 = "9")

                        NumbersView(num1 = "", num2 = "0", num3 = "", true)

                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Button(
                        onClick = {
                            navController.navigate(route = Screen.Home.route)
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                        modifier = Modifier
                            .fillMaxWidth(),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 3.dp,
                            pressedElevation = 0.dp
                        )
                    ) {
                        Text(
                            text = "Подтвердить",
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.muller_bold)),
                                fontSize = 14.sp
                            ),
                            modifier = Modifier.padding(5.dp)
                        )
                    }
                }

            }
        }

    }

}

@Composable
@Preview(showBackground = true)
fun PassCodePreview() {
    PassCodeView(navController = rememberNavController())
}
