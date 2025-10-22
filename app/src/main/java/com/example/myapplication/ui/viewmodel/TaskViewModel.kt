package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.local.TrafficStatus
import com.example.myapplication.domain.model.Task
import com.example.myapplication.domain.usecase.AddTaskUseCase
import com.example.myapplication.domain.usecase.DeleteTaskUseCase
import com.example.myapplication.domain.usecase.GetTaskByIdUseCase
import com.example.myapplication.domain.usecase.GetTasksUseCase
import com.example.myapplication.domain.usecase.UpdateTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TaskViewModel @Inject constructor(
    private val getTasksUseCase: GetTasksUseCase,
    private val addTaskUseCase: AddTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    private val getTaskByIdUseCase: GetTaskByIdUseCase
): ViewModel() {

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks

    init {
        loadTasks()
    }


    fun loadTasks(){
        viewModelScope.launch {
            _tasks.value = getTasksUseCase.execute()
        }
    }

    fun addTask(
        title: String,
        description: String? = null,
        locationName: String? = null,
        latitude: Double? = null,
        longitude: Double? = null,
        createdAt: Long,
        dueAt: Long? = null,
        isDone: Boolean = false,
        trafficStatus: TrafficStatus
    ){
        val task = Task(
            title = title,
            description = description,
            locationName = locationName,
            latitude = latitude,
            longitude = longitude,
            createdAt = createdAt,
            dueAt = dueAt,
            isDone = isDone,
            trafficStatus = trafficStatus
        )

        viewModelScope.launch {
            addTaskUseCase.execute(task)
            loadTasks()
        }
    }

    fun getTaskById(id: Long){
        viewModelScope.launch {
            getTaskByIdUseCase.execute(id)
        }
    }


    fun updateTask(task: Task){
        viewModelScope.launch {
            updateTaskUseCase.execute(task)
            loadTasks()
        }
    }

    fun deleteTask(task: Task){
        viewModelScope.launch {
            deleteTaskUseCase.execute(task)
        }
    }
}