package com.breckneck.funboxtest.domain.usecase

import com.breckneck.funboxtest.domain.model.ItemDomain
import com.breckneck.funboxtest.domain.repository.ItemRepository

class AddItemUseCase(val itemRepository: ItemRepository) {

    suspend fun execute(name: String, price: Double, quantity: Int) {
        itemRepository.addItem(ItemDomain(id = 0, name = name, price = price, quantity = quantity))
    }

}