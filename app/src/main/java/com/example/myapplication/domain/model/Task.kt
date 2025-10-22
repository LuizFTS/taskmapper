package com.example.myapplication.domain.model

import com.example.myapplication.data.local.TrafficStatus

data class Task(
    val id: Long = 0,
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