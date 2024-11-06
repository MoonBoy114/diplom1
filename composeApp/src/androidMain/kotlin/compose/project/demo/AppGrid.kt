package compose.project.demo

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import compose.composeapp.generated.resources.Res
import compose.composeapp.generated.resources.compose_multiplatform

@Composable
fun AppGrid() {
    val optionImages = mapOf(
        "Заметки" to R.drawable.notes,
        "Калькулятор" to R.drawable.calculator,
        "Переводчик" to R.drawable.translate,
        "Погода" to R.drawable.weather,
        "Камера" to R.drawable.camera,
        "Музыка" to R.drawable.music,

        )

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                val options = listOf("Заметки", "Калькулятор", "Переводчик", "Погода", "Камера", "Музыка")
                val gridSize = 2
                items(options.chunked(gridSize)) { rowOptions ->
                    Row(
                        Modifier
                            .fillMaxHeight(),
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        for (option in rowOptions) {
                            val imageResource = optionImages.getValue(option) // Уверен, что все ключи присутствуют
                            GridItem(option, imageResource, Modifier.weight(2f))
                        }
                    }
                }
            }

            BottomNavigationBar()
        }
    }
}
@Composable
fun BottomNavigationBar() {
    BottomNavigation(
        backgroundColor = Color.Gray,
        contentColor = Color.White
    ) {
        BottomNavigationItem(
            icon = { Image(
                painter = androidx.compose.ui.res.painterResource(R.drawable.settin), // Убедитесь, что ресурс доступен
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )},
            label = { Text("Настройки", fontWeight = FontWeight.Bold, color = Color.White) },
            selected = false,
            onClick = {  },
            modifier = Modifier.weight(1f)
        )

        BottomNavigationItem(
            icon = { Image(
                painter = androidx.compose.ui.res.painterResource(R.drawable.profile), // Убедитесь, что ресурс доступен
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )},
            label = { Text("Профиль", fontWeight = FontWeight.Bold, color = Color.White) },
            selected = false,
            onClick = {  },
            modifier = Modifier.weight(1f)
        )
        BottomNavigationItem(
            icon = { Image(
                painter = androidx.compose.ui.res.painterResource(R.drawable.about), // Убедитесь, что ресурс доступен
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )},
            label = { Text("О приложении", fontWeight = FontWeight.Bold, color = Color.White) },
            selected = false,
            onClick = {  },
            modifier = Modifier.weight(1f)
        )
    }
}
@Composable
fun GridItem(option: String, imageResource: Int, modifier: Modifier) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        modifier = modifier
            .size(300.dp)
            .clickable { /* действие */ }
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.LightGray)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = androidx.compose.ui.res.painterResource(imageResource),
                contentDescription = null,
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = option,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}