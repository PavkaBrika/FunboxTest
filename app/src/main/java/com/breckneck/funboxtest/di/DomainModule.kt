package com.breckneck.funboxtest.di

import com.breckneck.funboxtest.domain.usecase.AddItemUseCase
import com.breckneck.funboxtest.domain.usecase.CheckWasOpenedUseCase
import com.breckneck.funboxtest.domain.usecase.GetAllItemsUseCase
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
}