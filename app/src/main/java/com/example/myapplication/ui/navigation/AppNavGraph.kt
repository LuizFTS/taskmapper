package com.example.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.ui.screens.AddTaskScreen
import com.example.myapplication.ui.screens.SplashScreen
import com.example.myapplication.ui.screens.TaskListScreen
import com.example.myapplication.ui.viewmodel.TaskViewModel

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object TaskList : Screen("task_list")
    object AddTask : Screen("add_task")
}

@Composable
fun AppNavHost(navController: NavHostController, taskViewModel: TaskViewModel){
    NavHost(navController = navController, startDestination = Screen.Splash.route){
        composable(Screen.Splash.route){
            SplashScreen(navController)
        }

        composable(Screen.TaskList.route){
            TaskListScreen(navController, taskViewModel)
        }

        composable(Screen.AddTask.route){
            AddTaskScreen(navController, taskViewModel)
        }
    }
}