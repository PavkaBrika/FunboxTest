package com.breckneck.funboxtest.data.repository

import com.breckneck.funboxtest.data.ItemStorage
import com.breckneck.funboxtest.data.entity.Item
import com.breckneck.funboxtest.domain.model.ItemDomain
import com.breckneck.funboxtest.domain.repository.ItemRepository

class ItemRepositoryImpl(val itemStorage: ItemStorage) : ItemRepository {


    override fun addItem(itemDomain: ItemDomain) {
        itemStorage.addItem(Item(id = 0, name = itemDomain.name, price = itemDomain.price, quantity = itemDomain.quantity))
    }

}