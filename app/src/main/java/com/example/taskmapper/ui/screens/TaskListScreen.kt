package com.example.taskmapper.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.taskmapper.ui.navigation.Screen
import com.example.taskmapper.ui.theme.Green50
import com.example.taskmapper.ui.viewmodel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskListScreen(navController: NavController, taskViewModel: TaskViewModel){

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
             TopAppBar(
                colors = TopAppBarColors(
                    containerColor = Color(Green50.value),
                    titleContentColor = Color.White,
                    scrolledContainerColor = Color.LightGray,
                    navigationIconContentColor = Color.Green,
                    actionIconContentColor = Color.Red
                ),
                title = {
                    Text("TaskMapper")
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Screen.AddTask.route) },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ){
                Icon(Icons.Filled.Add, null)
            }
        }

    ) {paddingValues ->
        Column(
            Modifier
                .fillMaxSize()
                .background(Color.LightGray)
                .padding(paddingValues)
        ) {
            Text("TaskList")

        }
    }
}