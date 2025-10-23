package com.example.taskmapper.data.repository

import com.example.taskmapper.data.local.TaskDao
import com.example.taskmapper.data.local.TaskEntity
import com.example.taskmapper.domain.model.Task
import javax.inject.Inject

class TaskRepository @Inject constructor(
    private val dao: TaskDao
) {

    private fun TaskEntity.toDomain() = Task(
        id,
        title,
        description,
        locationName,
        latitude,
        longitude,
        createdAt,
        dueAt,
        isDone,
        trafficStatus,
    )

    private fun Task.toEntity() = TaskEntity(
        id,
        title,
        description,
        locationName,
        latitude,
        longitude,
        createdAt,
        dueAt,
        isDone,
        trafficStatus,
    )

    suspend fun getAllTasks(): List<Task> {
        return dao.getAllTasks().map { it.toDomain() }
    }

    suspend fun getTaskById(id: Long): Task? {
        return dao.getTaskById(id)?.toDomain()
    }

    suspend fun addTask(task: Task){
        dao.insertTask(task.toEntity())
    }

    suspend fun updateTask(task: Task){
        dao.updateTask(task.toEntity())
    }

    suspend fun deleteTask(task: Task){
        dao.deleteTask(task.toEntity())
    }
}