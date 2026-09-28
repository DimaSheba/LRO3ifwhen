package com.example.a03ifwhen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.a03ifwhen.ui.theme.ЛР03ifwhenTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Column

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ЛР03ifwhenTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Column {

                        var number by remember {
                            mutableStateOf("")
                        }

                        var output by remember {
                            mutableStateOf("")
                        }

                        OutlinedTextField(
                            value = number,
                            onValueChange = {
                                number = it
                            },
                            label = {
                                Text("Введите номер")
                            },
                            modifier = Modifier.padding(innerPadding)
                        )

                        Button(
                            onClick = {
                                val seasonNumber = number.toIntOrNull()

                                output = when (seasonNumber) {
                                    1 -> "Зима"
                                    2 -> "Весна"
                                    3 -> "Лето"
                                    4 -> "Осень"
                                    else -> "Ошибка"
                                }
                            }
                        ) {
                            Text("Определить")
                        }

                        OutlinedTextField(
                            value = output,
                            onValueChange = {},
                            label = {
                                Text("Результат")
                            },
                            readOnly = true
                        )
                    }

                }
            }
        }
    }
}

