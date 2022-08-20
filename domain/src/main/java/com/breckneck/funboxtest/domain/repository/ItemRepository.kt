package com.breckneck.funboxtest.domain.repository

import com.breckneck.funboxtest.domain.model.ItemDomain

interface ItemRepository {

    fun addItem(itemDomain: ItemDomain)

    fun getAllItems() : List<ItemDomain>
}