package com.example.taskmapper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.example.taskmapper.ui.navigation.AppNavHost
import com.example.taskmapper.ui.theme.MyApplicationTheme
import com.example.taskmapper.ui.viewmodel.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val taskViewModel: TaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyApplicationTheme {

                val navController = rememberNavController()

                AppNavHost(
                    navController = navController,
                    taskViewModel = taskViewModel
                )
            }
        }
    }
}