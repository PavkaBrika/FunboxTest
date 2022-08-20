package com.breckneck.funboxtest.domain.usecase

import com.breckneck.funboxtest.domain.model.ItemDomain
import com.breckneck.funboxtest.domain.repository.ItemRepository

class AddItemUseCase(val itemRepository: ItemRepository) {

    fun execute(name: String, price: Int, quantity: Int) {
        itemRepository.addItem(ItemDomain(name = name, price = price, quantity = quantity))
    }

}