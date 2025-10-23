package com.example.taskmapper.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.taskmapper.ui.navigation.Screen
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavHostController, appName: String = "utrien"){

    var visibleText by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        delay(400)
        appName.forEachIndexed { index, _ ->
            visibleText = appName.take(index + 1)
            delay(100)
        }

        delay(1000)

        navController.navigate(Screen.TaskList.route){
            popUpTo(Screen.Splash.route){ inclusive = true }
        }
    }

    Row(
        modifier = Modifier.fillMaxSize()
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ){
        Image(
            painter = painterResource(id = com.example.taskmapper.R.drawable.ic_logo_n),
            contentDescription = "App logo",
            modifier = Modifier
                .size(50.dp)
        )

        Text(
            text = visibleText,
            style = TextStyle(
                color = Color.Black,
                fontSize = 50.sp,
                fontFamily = FontFamily(Font(com.example.taskmapper.R.font.ibmplexsans_semibolditalic)),
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp
            )
        )
    }
}