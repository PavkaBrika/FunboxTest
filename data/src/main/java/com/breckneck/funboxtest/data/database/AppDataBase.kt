package com.breckneck.funboxtest.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.breckneck.funboxtest.data.entity.Item

@Database(entities = [Item::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun appDao() : AppDao
}