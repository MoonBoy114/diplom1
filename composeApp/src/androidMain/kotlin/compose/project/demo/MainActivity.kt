package compose.project.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isLog = remember { mutableStateOf(false) }
            val isRegistering = remember { mutableStateOf(false) }
            val errorMessage = remember { mutableStateOf<String?>(null) }

            Crossfade(targetState = when {
                isLog.value -> "LoggedIn"
                isRegistering.value -> "Registering"
                else -> "Login"
            }, label = "animation"
            ) { screen ->
                when (screen) {
                    "LoggedIn" -> AppGrid()
                    "Login" -> LoginScreenAndroid(
                        onLoginClick = { username, password ->
                            if (username == "admin" && password == "password") {
                                isLog.value = true
                            } else {

                                errorMessage.value = "Неверное имя пользователя или пароль"
                            }
                        },
                        onRegisterClick = { isRegistering.value = true },
                        errorMessage = errorMessage.value
                    )
                    "Registering" -> RegistrationScreen(
                        onBackClick = { isRegistering.value = false }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    AppGrid()
}