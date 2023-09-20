package com.bintangpoetra.moneybox.domain.wallet.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Wallet(
    val id: Int,
    val walletName: String,
    val initialNominal: Int,
    val description: String
)
