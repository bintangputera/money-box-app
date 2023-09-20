package com.bintangpoetra.moneybox.data.wallet.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wallet")
data class WalletEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "wallet_name")
    val walletName: String,

    @ColumnInfo(name = "initial_nominal")
    val initialNominal: Int,

    @ColumnInfo(name = "description")
    val description: String
)