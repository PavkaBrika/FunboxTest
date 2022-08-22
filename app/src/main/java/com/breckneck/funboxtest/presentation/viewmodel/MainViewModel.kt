package com.breckneck.funboxtest.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.breckneck.funboxtest.domain.model.ItemDomain
import com.breckneck.funboxtest.domain.usecase.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
    private val getAllItems: GetAllItemsUseCase,
    private val updateItem: UpdateItemUseCase,
    private val addItem: AddItemUseCase,
    private val buyItem: BuyItemUseCase,
    private val getItemById: GetItemByIdUseCase
) : ViewModel() {

    var resultItemList = MutableLiveData<List<ItemDomain>>()
    var resultItem = MutableLiveData<ItemDomain>()

    init {
        Log.e("TAG", "VM created")
    }

    override fun onCleared() {
        Log.e("TAG", "VM cleared")
        super.onCleared()
    }

    fun getAllItems() {
        viewModelScope.launch {
            val items = getAllItems.execute()
            resultItemList.value = items
            Log.e("TAG", "Get items from VM")
        }
    }

    fun updateItem(item: ItemDomain) {
        viewModelScope.launch {
            delay(5000)
            updateItem.execute(itemDomain = item)
            Log.e("TAG", "Item Updated")
            getAllItems()
        }
    }

    fun buyItem(item: ItemDomain) {
        viewModelScope.launch {
            delay(3000)
            buyItem.execute(itemDomain = item)
            getAllItems()
        }
    }

    fun getItemById(id: Int) {
        viewModelScope.launch {
            val item = getItemById.execute(id = id)
            resultItem.value = item
            Log.e("TAG", "Got item from VM")
        }
    }

    fun addItem(name: String, price: Double, quantity: Int) {
        viewModelScope.launch {
            delay(5000)
            addItem.execute(name = name, price = price, quantity = quantity)
            getAllItems()
        }
    }

}