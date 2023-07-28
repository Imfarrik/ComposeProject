package com.example.noinsoft.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
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
import com.example.noinsoft.R

@Composable
fun NumbersView(num1: String, num2: String, num3: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {
            Text(
                text = num1,
                style = TextStyle(
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.commissioner_medium)),
                    fontSize = 24.sp
                )
            )
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {
            Text(
                text = num2,
                style = TextStyle(
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.commissioner_medium)),
                    fontSize = 24.sp
                )
            )
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {
            Text(
                text = num3,
                style = TextStyle(
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.commissioner_medium)),
                    fontSize = 24.sp
                )
            )
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PassCodeView() {

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

                        NumbersView(num1 = "1", num2 = "2", num3 = "3")

                        NumbersView(num1 = "4", num2 = "5", num3 = "6")

                        NumbersView(num1 = "7", num2 = "8", num3 = "9")
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                        modifier = Modifier
                            .fillMaxWidth()
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
