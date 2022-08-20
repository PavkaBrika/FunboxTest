package com.breckneck.funboxtest.data

import com.breckneck.funboxtest.data.entity.Item

interface ItemDataBaseStorage {

    suspend fun addItem(item: Item)

    suspend fun getAllItems() : List<Item>

}