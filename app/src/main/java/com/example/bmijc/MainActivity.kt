package com.example.bmijc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.example.bmijc.screen.Main_screen
import com.example.bmijc.ui.theme.BMIJCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(Color(0xFF0D0C1D).toArgb()),
            navigationBarStyle = SystemBarStyle.dark(Color(0xFF0D0C1D).toArgb())
        )
        setContent {
            BMIJCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Main_screen(applicationContext)
                    }
                }
            }
        }
    }
}
