package com.techun.dev.tuskillgt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.techun.dev.tuskillgt.ui.main.MainScreen
import com.techun.dev.tuskillgt.ui.theme.TUSkillGTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TUSkillGTTheme {
//                LoginScreen { }
                MainScreen()
            }
        }
    }
}