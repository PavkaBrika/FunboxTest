package com.breckneck.funboxtest.data

import com.breckneck.funboxtest.data.entity.Item

interface ItemStorage {

    fun addItem(item: Item)

}