package com.breckneck.funboxtest.data

interface ItemSharedPrefsStorage {

    suspend fun wasOpened() : Boolean

}