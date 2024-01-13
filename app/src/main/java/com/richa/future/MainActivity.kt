package com.richa.future

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.richa.future.ui.screen.HomeScreen
import com.richa.future.ui.theme.FUTURETheme
import com.richa.future.ui.theme.MyFontHolder
import com.richa.future.ui.theme.boldStyle
import com.richa.future.ui.theme.semiBoldStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FUTURETheme {
                HomeScreen()
            }
        }
    }
}