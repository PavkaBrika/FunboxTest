package com.breckneck.funboxtest.domain.usecase

import com.breckneck.funboxtest.domain.model.ItemDomain
import com.breckneck.funboxtest.domain.repository.ItemRepository

class DeleteItemUseCase(val itemRepository: ItemRepository) {

    suspend fun execute(itemDomain: ItemDomain) {
        itemRepository.deleteItem(itemDomain = itemDomain)
    }
}