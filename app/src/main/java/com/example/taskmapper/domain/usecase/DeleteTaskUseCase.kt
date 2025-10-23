package com.example.taskmapper.domain.usecase

import com.example.taskmapper.data.repository.TaskRepository
import com.example.taskmapper.domain.model.Task
import javax.inject.Inject

class DeleteTaskUseCase @Inject constructor(
    private val repository: TaskRepository
) {
    suspend fun execute(task: Task){
        repository.deleteTask(task)
    }
}