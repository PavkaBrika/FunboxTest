package com.breckneck.funboxtest.di

import com.breckneck.funboxtest.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel> {
        MainViewModel(
            getAllItems = get(),
            updateItem = get(),
            addItem = get(),
            buyItem = get(),
            getItemById = get()
        )
    }
}