package com.example.taskmapper.domain.usecase

import com.example.taskmapper.data.repository.TaskRepository
import com.example.taskmapper.domain.model.Task
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    suspend fun execute(): List<Task>{
        return repository.getAllTasks()
    }
}