package univ.earthbreaker.namu.feature.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import univ.earthbreaker.namu.MainActivity
import univ.earthbreaker.namu.util.finishSafely

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen(onClickLoginButton = navigateToMain)
        }
    }

    private val navigateToMain: () -> Unit = {
        startActivity(Intent(this, MainActivity::class.java))
        finishSafely()
    }
}
