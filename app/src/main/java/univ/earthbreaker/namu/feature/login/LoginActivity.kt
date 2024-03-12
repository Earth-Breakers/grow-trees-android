package univ.earthbreaker.namu.feature.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import univ.earthbreaker.namu.feature.home.HomeActivity
import univ.earthbreaker.namu.util.finishSafely

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen(onClickLoginButton = navigateToHome)
        }
    }

    private val navigateToHome: () -> Unit = {
        startActivity(Intent(this, HomeActivity::class.java))
        finishSafely()
    }
}
