package com.breckneck.funboxtest.data

import com.breckneck.funboxtest.data.entity.Item

interface ItemDataBaseStorage {

    suspend fun addItem(item: Item)

    suspend fun getAllItems(): List<Item>

    suspend fun getItemById(id: Int): Item

    suspend fun updateItem(item: Item)

    suspend fun deleteItem(item: Item)

    suspend fun getJsonString(items: List<Item>): String
}