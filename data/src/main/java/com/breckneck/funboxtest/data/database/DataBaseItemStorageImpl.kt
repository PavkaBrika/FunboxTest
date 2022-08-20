package com.breckneck.funboxtest.data.database

import android.content.Context
import androidx.room.Room
import com.breckneck.funboxtest.data.ItemStorage
import com.breckneck.funboxtest.data.entity.Item

private val SHARED_PREFS_NAME = "shared_prefs_name"
private val ITEM_ID = "itemid"

class DataBaseItemStorageImpl(context: Context) : ItemStorage {

    val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    val db = Room.databaseBuilder(context, AppDataBase::class.java, "ItemDataBase").build()


    override fun addItem(item: Item) {
        var itemId = sharedPreferences.getInt(ITEM_ID, 0)
        item.id = itemId
        itemId++
        db.appDao().insertItem(item = item)
        sharedPreferences.edit().putInt(ITEM_ID, itemId).apply()
    }

    override fun getAllItems(): List<Item> {
        return db.appDao().getAllItem()
    }


}