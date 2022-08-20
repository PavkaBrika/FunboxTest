package com.breckneck.funboxtest.data.sharedprefs

import android.content.Context
import com.breckneck.funboxtest.data.ItemSharedPrefsStorage


private val SHARED_PREFS = "shared_prefs"
private val WAS_OPENED = "was_opened"

class ItemSharedPrefsStorageImpl(context: Context) : ItemSharedPrefsStorage {

    val sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

    override suspend fun wasOpened(): Boolean {
        val wasOpened = sharedPreferences.getBoolean(WAS_OPENED, false)
        sharedPreferences.edit().putBoolean(WAS_OPENED, true).apply()
        return wasOpened
    }

}