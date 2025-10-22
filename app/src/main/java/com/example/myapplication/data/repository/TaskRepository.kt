package com.example.myapplication.data.repository

import android.content.Context
import com.example.myapplication.data.local.TaskDao
import com.example.myapplication.data.local.TaskDatabase
import com.example.myapplication.data.local.TaskEntity
import com.example.myapplication.data.local.TrafficStatus
import com.example.myapplication.domain.model.Task
import kotlin.String

class TaskRepository(context: Context? = null) {

    private val taskDao: TaskDao by lazy {
        requireNotNull(context) { "Context required to initialize database" }
        TaskDatabase.getDatabase(context).taskDao()
    }

    private fun TaskEntity.toDomain() = Task(
        id = this.id,
        title = this.title,
        description = this.description,
        locationName = this.locationName,
        latitude = this.latitude,
        longitude = this.longitude,
        createdAt = this.createdAt,
        dueAt = this.dueAt,
        isDone = this.isDone,
        trafficStatus = this.trafficStatus,
    )

    private fun Task.toEntity() = TaskEntity(
        id = this.id,
        title = this.title,
        description = this.description,
        locationName = this.locationName,
        latitude = this.latitude,
        longitude = this.longitude,
        createdAt = this.createdAt,
        dueAt = this.dueAt,
        isDone = this.isDone,
        trafficStatus = this.trafficStatus,
    )

    suspend fun getAllTasks(): List<Task> {
        return taskDao.getAllTasks().map { it.toDomain() }
    }

    suspend fun getTaskById(id: Long): Task? {
        return taskDao.getTaskById(id)?.toDomain()
    }

    suspend fun addTask(task: Task){
        taskDao.insertTask(task.toEntity())
    }

    suspend fun updateTask(task: Task){
        taskDao.updateTask(task.toEntity())
    }

    suspend fun deleteTask(task: Task){
        taskDao.deleteTask(task.toEntity())
    }
}