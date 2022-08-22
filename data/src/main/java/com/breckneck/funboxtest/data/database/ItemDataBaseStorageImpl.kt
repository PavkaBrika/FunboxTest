package com.breckneck.funboxtest.data.database

import android.content.Context
import androidx.room.Room
import com.breckneck.funboxtest.data.ItemDataBaseStorage
import com.breckneck.funboxtest.data.entity.Item
import com.google.gson.GsonBuilder

private val SHARED_PREFS_NAME = "shared_prefs_name"
private val ITEM_ID = "itemid"

class ItemDataBaseStorageImpl(context: Context) : ItemDataBaseStorage {

    val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    val db = Room.databaseBuilder(context, AppDataBase::class.java, "ItemDataBase").build()


    override suspend fun addItem(item: Item) {
        var itemId = sharedPreferences.getInt(ITEM_ID, 0)
        item.id = itemId
        itemId++
        db.appDao().insertItem(item = item)
        sharedPreferences.edit().putInt(ITEM_ID, itemId).apply()
    }

    override suspend fun getAllItems(): List<Item> {
        return db.appDao().getAllItem()
    }

    override suspend fun getItemById(id: Int): Item {
        return db.appDao().getItemById(id = id)
    }

    override suspend fun updateItem(item: Item) {
        db.appDao().updateItem(item = item)
    }

    override suspend fun deleteItem(item: Item) {
        db.appDao().deleteItem(item = item)
    }

    override suspend fun getJsonString(items: List<Item>): String {
        val gsonBuilder = GsonBuilder()
        val gson = gsonBuilder.create()
        return gson.toJson(items)
    }
}