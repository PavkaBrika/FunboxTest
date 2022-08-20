package com.breckneck.funboxtest.domain.repository

import com.breckneck.funboxtest.domain.model.ItemDomain

interface ItemRepository {

    suspend fun addItem(itemDomain: ItemDomain)

    suspend fun getAllItems() : List<ItemDomain>

    suspend fun wasOpened() : Boolean
}