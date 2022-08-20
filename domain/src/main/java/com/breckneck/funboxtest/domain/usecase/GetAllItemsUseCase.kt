package com.breckneck.funboxtest.domain.usecase

import com.breckneck.funboxtest.domain.model.ItemDomain
import com.breckneck.funboxtest.domain.repository.ItemRepository

class GetAllItemsUseCase(val itemRepository: ItemRepository) {

    fun execute() : List<ItemDomain> {
        return itemRepository.getAllItems()
    }
}