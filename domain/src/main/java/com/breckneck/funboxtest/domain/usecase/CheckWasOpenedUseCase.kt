package com.breckneck.funboxtest.domain.usecase

import com.breckneck.funboxtest.domain.repository.ItemRepository


class CheckWasOpenedUseCase(val itemRepository: ItemRepository) {

    suspend fun execute() : Boolean {
        return itemRepository.wasOpened()
    }
}