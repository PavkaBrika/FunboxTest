package com.breckneck.funboxtest.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    @PrimaryKey
    var id: Int,
    val name: String,
    val price: Int,
    val quantity: Int)
