package com.example.taskmapper.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.taskmapper.ui.viewmodel.TaskViewModel

@Composable
fun AddTaskScreen(navController: NavController, taskViewModel: TaskViewModel){

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Text("AddTask")
    }
}