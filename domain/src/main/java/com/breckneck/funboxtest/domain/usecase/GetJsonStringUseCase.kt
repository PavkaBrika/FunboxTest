package com.breckneck.funboxtest.domain.usecase

import com.breckneck.funboxtest.domain.model.ItemDomain
import com.breckneck.funboxtest.domain.repository.ItemRepository

class GetJsonStringUseCase(val itemRepository: ItemRepository) {

    suspend fun execute(items: List<ItemDomain>) : String {
        return itemRepository.getJsonString(items = items)
    }
}