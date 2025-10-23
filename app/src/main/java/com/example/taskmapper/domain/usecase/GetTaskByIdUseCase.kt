package com.example.taskmapper.domain.usecase

import com.example.taskmapper.data.repository.TaskRepository
import com.example.taskmapper.domain.model.Task
import javax.inject.Inject

class GetTaskByIdUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    suspend fun execute(id: Long): Task? {
        return repository.getTaskById(id)
    }
}