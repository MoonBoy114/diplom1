package compose.project.demo

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreenAndroid(
    onLoginClick: (String, String) -> Unit,
    onRegisterClick: () -> Unit,
    errorMessage: String? = null
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        // Logo and title row
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth(),
        ) {
            Spacer(modifier = Modifier.width(12.dp))
            Image(
                painter = painterResource(R.drawable.logos), // Убедитесь, что logo.svg доступен в res/drawable как logo.xml или аналогичный формат
                contentDescription = "Logo",
                modifier = Modifier
                    .height(80.dp)  // Задаем размер логотипа
                    .clip(CircleShape)  // Делаем логотип круглым// Adjust height as needed
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "STANDPACK",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        // Username field
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Имя пользователя", style = MaterialTheme.typography.body1) },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .padding(vertical = 8.dp, horizontal = 16.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface,
                textColor = MaterialTheme.colors.onSurface,
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = MaterialTheme.colors.onSurface.copy(alpha = 0.5f),
                placeholderColor = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
            ),
            shape = RoundedCornerShape(10.dp),
            singleLine = true,
            textStyle = LocalTextStyle.current.copy(fontSize = 18.sp, lineHeight = 24.sp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password field
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Пароль", style = MaterialTheme.typography.body1) },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .padding(vertical = 8.dp, horizontal = 16.dp),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Text(if (passwordVisible) "Скрыть" else "Показать")
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface,
                textColor = MaterialTheme.colors.onSurface,
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = MaterialTheme.colors.onSurface.copy(alpha = 0.5f),
                placeholderColor = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
            ),
            shape = RoundedCornerShape(10.dp),
            singleLine = true,
            textStyle = LocalTextStyle.current.copy(fontSize = 18.sp, lineHeight = 24.sp)
        )

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = { onLoginClick(username, password) },
            modifier = Modifier
                .width(100.dp)
                .clip(RoundedCornerShape(8.dp)),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Black
            )
        ) {
            Text("Вход", style = MaterialTheme.typography.button, color = Color.White, fontSize = 20.sp)
        }


        errorMessage?.let {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = it,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Вы еще не зарегистрированы? ",
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onSurface
        )
        Text(
            text = "Вперед регистрироваться!",
            style = MaterialTheme.typography.body1.copy(color = Color.Blue),
            modifier = Modifier.clickable { onRegisterClick() }
        )



    }
}