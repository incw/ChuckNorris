package dev.smolyakoff.chucknorris.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import dev.smolyakoff.chucknorris.navigation.NorrisNavHost
import dev.smolyakoff.chucknorris.theme.NorrisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            NorrisTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NorrisNavHost(Modifier.systemBarsPadding())
                }

            }
        }
    }
}
