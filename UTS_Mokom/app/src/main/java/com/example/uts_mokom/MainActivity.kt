package com.example.uts_mokom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uts_mokom.ui.theme.UTS_MokomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UTS_MokomTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AplikasiNavigasi()
                }
            }
        }
    }
}

@Composable
fun AplikasiNavigasi() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "beranda") {
        composable("beranda") {
            LayarBeranda(navController = navController)
        }

        composable("profil") {
            LayarProfil(navController = navController)
        }

    }
}

@Composable
fun LayarBeranda(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Ini adalah Halaman Beranda")
        Button(onClick = {
            navController.navigate("profil")
        }) {
            Text("Pergi ke Profil")
        }
    }
}

@Composable
fun LayarProfil(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Ini adalah Halaman Profil")
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("Kembali ke Beranda")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UTS_MokomTheme {
        AplikasiNavigasi()
    }
}
