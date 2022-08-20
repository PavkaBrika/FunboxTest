package com.breckneck.funboxtest.data.repository

import com.breckneck.funboxtest.data.ItemDataBaseStorage
import com.breckneck.funboxtest.data.ItemSharedPrefsStorage
import com.breckneck.funboxtest.data.entity.Item
import com.breckneck.funboxtest.domain.model.ItemDomain
import com.breckneck.funboxtest.domain.repository.ItemRepository

class ItemRepositoryImpl(val itemDataBaseStorage: ItemDataBaseStorage, val itemSharedPrefsStorage: ItemSharedPrefsStorage) : ItemRepository {


    override suspend fun addItem(itemDomain: ItemDomain) {
        itemDataBaseStorage.addItem(Item(id = 0, name = itemDomain.name, price = itemDomain.price, quantity = itemDomain.quantity))
    }

    override suspend fun getAllItems(): List<ItemDomain> {
        val items = itemDataBaseStorage.getAllItems()
        return items.map {
            ItemDomain(id = it.id, name = it.name, price = it.price, quantity = it.quantity)
        }
    }

    override suspend fun wasOpened(): Boolean {
        return itemSharedPrefsStorage.wasOpened()
    }
}