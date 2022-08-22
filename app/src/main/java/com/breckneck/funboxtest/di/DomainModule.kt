package com.breckneck.funboxtest.di

import com.breckneck.funboxtest.domain.usecase.*
import org.koin.dsl.module

val domainModule = module {

    factory<GetAllItemsUseCase> {
        GetAllItemsUseCase(itemRepository = get())
    }

    factory<AddItemUseCase> {
        AddItemUseCase(itemRepository = get())
    }

    factory<CheckWasOpenedUseCase> {
        CheckWasOpenedUseCase(itemRepository = get())
    }

    factory<GetItemByIdUseCase> {
        GetItemByIdUseCase(itemRepository = get())
    }

    factory<UpdateItemUseCase> {
        UpdateItemUseCase(itemRepository = get())
    }

    factory<DeleteItemUseCase> {
        DeleteItemUseCase(itemRepository = get())
    }

    factory<BuyItemUseCase> {
        BuyItemUseCase(itemRepository = get())
    }
}