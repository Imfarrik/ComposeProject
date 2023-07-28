@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.example.noinsoft.screens

import android.widget.Spinner
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noinsoft.R

@Preview(showBackground = true)
@Composable
fun LoginScreen() {

    Image(
        painter = painterResource(id = R.drawable.splash_bg),
        contentDescription = "background image",
        modifier = Modifier.fillMaxSize()
    )

    Column(modifier = Modifier.fillMaxSize()) {


        Column {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .padding(top = 48.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(id = R.drawable.splash_screen_logo),
                    contentDescription = "logo",

                    )

                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
                    Button(onClick = { /*TODO*/ }) {

                    }
                }

            }

            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Black)) {
                        append("Система ")
                    }
                    withStyle(style = SpanStyle(color = Color(0xFF676776))) {
                        append("управления процессом ")
                    }
                    withStyle(style = SpanStyle(color = Color.Black)) {
                        append("взыскания задолженности")
                    }
                },
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .padding(top = 32.dp),
                style = TextStyle(
                    fontSize = 28.sp,
                    fontFamily = FontFamily(Font(R.font.muller_bold)),
                    letterSpacing = 1.sp,
                    lineHeight = 30.sp
                )
            )


        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 28.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            var text by remember {
                mutableStateOf("Type")
            }

            OutlinedTextField(
                value = text, onValueChange = {
                    text = it
                },
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                label = {
                    Text(text = "Ваш номер")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Go
                ), keyboardActions = KeyboardActions(onDone = {
                    /*TODO*/
                }),
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.Gray
                )
            )

            Button(
                onClick = {
                    /*TODO*/
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {

                Text(
                    text = "Войти",
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

