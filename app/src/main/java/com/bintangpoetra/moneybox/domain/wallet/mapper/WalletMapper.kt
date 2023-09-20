package com.bintangpoetra.moneybox.domain.wallet.mapper

import com.bintangpoetra.moneybox.data.category.local.CategoryEntity
import com.bintangpoetra.moneybox.data.wallet.local.WalletEntity
import com.bintangpoetra.moneybox.domain.category.model.Category
import com.bintangpoetra.moneybox.domain.wallet.model.Wallet

fun WalletEntity.toDomain(): Wallet {
    return Wallet(
        this.id,
        this.walletName,
        this.initialNominal,
        this.description
    )
}

fun Wallet.toEntity(): WalletEntity {
    return WalletEntity(
        this.id,
        this.walletName,
        this.initialNominal,
        this.description
    )
}