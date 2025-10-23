package com.example.taskmapper.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.taskmapper.ui.screens.AddTaskScreen
import com.example.taskmapper.ui.screens.SplashScreen
import com.example.taskmapper.ui.screens.TaskListScreen
import com.example.taskmapper.ui.viewmodel.TaskViewModel
import androidx.compose.animation.*
import androidx.compose.animation.core.tween


sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object TaskList : Screen("task_list")
    object AddTask : Screen("add_task")
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavHost(navController: NavHostController, taskViewModel: TaskViewModel){

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ){

        composable(
            route = Screen.Splash.route
        ){
            SplashScreen(navController)
        }

        @OptIn(ExperimentalAnimationApi::class)
        composable(
            route = Screen.TaskList.route,


            enterTransition = { slideInHorizontally(initialOffsetX = { -it }, animationSpec = tween(300))},
            exitTransition = { slideOutHorizontally(targetOffsetX = { -it }, animationSpec = tween(300))},
            popEnterTransition =  { slideInHorizontally(initialOffsetX = { -it }, animationSpec = tween(300))},
            popExitTransition = { slideOutHorizontally(targetOffsetX = { it }, animationSpec = tween(300))}
            ){
            TaskListScreen(navController, taskViewModel)
        }

        composable(
            route = Screen.AddTask.route,
            enterTransition = { slideInHorizontally(initialOffsetX = { it }, animationSpec = tween(300)) },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -it }, animationSpec = tween(300)) },
            popEnterTransition =  { slideInHorizontally(initialOffsetX = { -it }, animationSpec = tween(300)) },
            popExitTransition = { slideOutHorizontally(targetOffsetX = { it }, animationSpec = tween(300)) }
            ){
            AddTaskScreen(navController, taskViewModel)
        }
    }
}