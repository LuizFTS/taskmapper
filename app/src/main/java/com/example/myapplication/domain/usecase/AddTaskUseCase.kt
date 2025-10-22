package com.example.myapplication.domain.usecase

import com.example.myapplication.data.repository.TaskRepository
import com.example.myapplication.domain.model.Task

class AddTaskUseCase(
    private val repository: TaskRepository
) {
    suspend fun execute(task: Task) {
        repository.addTask(task)
    }
}