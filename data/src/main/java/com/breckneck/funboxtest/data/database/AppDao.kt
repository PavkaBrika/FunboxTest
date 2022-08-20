package com.breckneck.funboxtest.data.database

import androidx.room.*
import com.breckneck.funboxtest.data.entity.Item

@Dao
interface AppDao {

    @Query("SELECT * FROM item")
    suspend fun getAllItem() : List<Item>

    @Insert
    suspend fun insertItem(item: Item)

    @Delete
    suspend fun deleteItem(item: Item)

    @Update
    suspend fun updateItem(item: Item)

}