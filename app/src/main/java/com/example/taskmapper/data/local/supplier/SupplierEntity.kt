package com.example.taskmapper.data.local.supplier

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "suppliers")
data class SupplierEntity (
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    val email: String,
    val taxId: String,
    val phone: String
)