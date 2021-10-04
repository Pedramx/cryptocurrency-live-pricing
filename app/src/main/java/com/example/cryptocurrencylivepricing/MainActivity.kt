package com.example.cryptocurrencylivepricing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.cryptocurrencylivepricing.component.CryptoLivePricingHomeContent
import com.example.cryptocurrencylivepricing.ui.theme.CryptocurrencyLivePricingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyLivePricingTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptocurrencyLivePricingTheme {
        Greeting("Android")
    }
}

@Composable
fun MyApp() {
    Scaffold(
        content = {
            CryptoLivePricingHomeContent()
        }
    )
}