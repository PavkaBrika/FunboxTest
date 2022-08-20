package com.breckneck.funboxtest.domain.usecase

import com.breckneck.funboxtest.domain.model.ItemDomain
import com.breckneck.funboxtest.domain.repository.ItemRepository

class GetItemByIdUseCase(private val itemRepository: ItemRepository) {

    suspend fun execute(id: Int) : ItemDomain {
        return itemRepository.getItemById(id = id)
    }
}