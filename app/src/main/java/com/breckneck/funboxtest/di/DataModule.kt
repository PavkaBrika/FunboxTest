package com.breckneck.funboxtest.di

import com.breckneck.funboxtest.data.ItemDataBaseStorage
import com.breckneck.funboxtest.data.ItemSharedPrefsStorage
import com.breckneck.funboxtest.data.database.ItemDataBaseStorageImpl
import com.breckneck.funboxtest.data.repository.ItemRepositoryImpl
import com.breckneck.funboxtest.data.sharedprefs.ItemSharedPrefsStorageImpl
import com.breckneck.funboxtest.domain.repository.ItemRepository
import org.koin.dsl.module

val dataModule = module {

    single<ItemDataBaseStorage> {
        ItemDataBaseStorageImpl(context = get())
    }

    single<ItemSharedPrefsStorage> {
        ItemSharedPrefsStorageImpl(context = get())
    }

    single<ItemRepository> {
        ItemRepositoryImpl(itemDataBaseStorage = get(), itemSharedPrefsStorage = get())
    }
}