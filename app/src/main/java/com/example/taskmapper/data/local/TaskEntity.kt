package com.example.taskmapper.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


enum class TrafficStatus { LIGHT, MODERATE, HEAVY }

@Entity(tableName = "tasks")
data class TaskEntity(

    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String? = null,
    val locationName: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val createdAt: Long,
    val dueAt: Long? = null,
    val isDone: Boolean = false,
    val trafficStatus: TrafficStatus
)