package com.breckneck.funboxtest.data.database

import androidx.room.*
import com.breckneck.funboxtest.data.entity.Item

@Dao
interface AppDao {

    @Query("SELECT * FROM item")
    fun getAllItem() : List<Item>

    @Insert
    fun insertItem(item: Item)

    @Delete
    fun deleteItem(item: Item)

    @Update
    fun updateItem(item: Item)

}