package com.breckneck.funboxtest.domain.usecase

import com.breckneck.funboxtest.domain.model.ItemDomain
import com.breckneck.funboxtest.domain.repository.ItemRepository

class BuyItemUseCase(val itemRepository: ItemRepository) {

    suspend fun execute(itemDomain: ItemDomain) {
        if (itemDomain.quantity - 1 != 0)
            itemRepository.updateItem(itemDomain = ItemDomain(id = itemDomain.id, name = itemDomain.name, price = itemDomain.price, quantity = itemDomain.quantity - 1))
        else
            itemRepository.deleteItem(itemDomain = ItemDomain(id = itemDomain.id, name = itemDomain.name, price = itemDomain.price, quantity = itemDomain.quantity))
    }
}