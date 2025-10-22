package com.example.myapplication.domain.usecase

import com.example.myapplication.data.repository.TaskRepository
import com.example.myapplication.domain.model.Task

class GetTasksUseCase(
    private val repository: TaskRepository
) {
    suspend fun execute(): List<Task>{
        return repository.getAllTasks()
    }
}