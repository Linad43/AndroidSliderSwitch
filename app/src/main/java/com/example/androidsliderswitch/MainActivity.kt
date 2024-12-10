package com.example.androidsliderswitch

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainFun()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun MainFun() {
    val mContext = LocalContext.current
    val switch = rememberSaveable { mutableStateOf(false) }
    val flagColor = rememberSaveable { mutableStateOf(false) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Люблю грозу в начале мая,\n" +
                    "Когда весенний, первый гром,\n" +
                    "Как бы резвяся и играя,\n" +
                    "Грохочет в небе голубом.",
            color = if (flagColor.value) Color.Black else Color.White
        )
        Button(
            onClick = {
                if (switch.value) {
                    flagColor.value = true
                    Toast.makeText(
                        mContext,
                        "Данные загружены",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        mContext,
                        "Нет доступа",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        ) {
            Text(
                text = "Загрузка данных"
            )
        }
        Switch(
            checked = switch.value,
            onCheckedChange = {
                switch.value = it
            }
        )
    }
}