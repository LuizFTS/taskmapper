package com.example.myapplication.domain.usecase

import com.example.myapplication.data.repository.TaskRepository
import com.example.myapplication.domain.model.Task

class GetTaskByIdUseCase(
    private val repository: TaskRepository
) {
    suspend fun execute(id: Long): Task? {
        return repository.getTaskById(id)
    }
}