package com.bintangpoetra.moneybox.domain.saving.model

data class Saving(
    val id: Int,
    val nominal: Int,
    val type: String,
    val notes: String,
    val date: String
)
