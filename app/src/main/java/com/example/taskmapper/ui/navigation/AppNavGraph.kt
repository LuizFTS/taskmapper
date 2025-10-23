package com.example.taskmapper.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.ui.platform.LocalConfiguration
import com.example.taskmapper.ui.screens.AddTaskScreen
import com.example.taskmapper.ui.screens.SplashScreen
import com.example.taskmapper.ui.screens.TaskListScreen
import com.example.taskmapper.ui.viewmodel.TaskViewModel
import androidx.compose.animation.*
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp


sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object TaskList : Screen("task_list")
    object AddTask : Screen("add_task")
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavHost(navController: NavHostController, taskViewModel: TaskViewModel){
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current
    val screenWidthPx = with(density) { configuration.screenWidthDp.dp.roundToPx() }

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
            enterTransition = { slideInHorizontally(initialOffsetX = { screenWidthPx }) + fadeIn() },
            exitTransition = { slideOutHorizontally(targetOffsetX = { +screenWidthPx }) + fadeOut() },
            popEnterTransition =  { slideInHorizontally { screenWidthPx } + fadeIn()},
            popExitTransition = { slideOutHorizontally { -screenWidthPx } + fadeOut()}
            ){
            TaskListScreen(navController, taskViewModel)
        }

        composable(
            route = Screen.AddTask.route,
            enterTransition = { slideInHorizontally(initialOffsetX = { screenWidthPx }) + fadeIn() },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -screenWidthPx }) + fadeOut() },
            popEnterTransition =  { slideInHorizontally { -screenWidthPx } + fadeIn()},
            popExitTransition = { slideOutHorizontally { screenWidthPx } + fadeOut()}
            ){
            AddTaskScreen(navController, taskViewModel)
        }
    }
}