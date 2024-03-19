package univ.earthbreaker.namu.feature.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen(
                level = 1,
                exp = 0.7f,
                energyCount = 1,
                currentEnergy = 1,
                requiredEnergy = 3,
            )
        }
    }
}
