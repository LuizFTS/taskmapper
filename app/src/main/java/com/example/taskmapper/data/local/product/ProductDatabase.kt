package com.example.taskmapper.data.local.product

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ProductEntity::class], version = 1)
abstract class ProductDatabase: RoomDatabase() {
    abstract fun productDao(): ProductDao
}
