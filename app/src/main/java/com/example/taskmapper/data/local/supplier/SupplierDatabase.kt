package com.example.taskmapper.data.local.supplier

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SupplierEntity::class], version = 1)
abstract class SupplierDatabase: RoomDatabase() {
    abstract fun supplierDao(): SupplierDao
}