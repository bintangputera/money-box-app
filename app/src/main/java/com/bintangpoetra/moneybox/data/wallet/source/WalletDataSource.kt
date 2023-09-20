package com.bintangpoetra.moneybox.data.wallet.source

import com.bintangpoetra.moneybox.data.wallet.local.WalletDao
import com.bintangpoetra.moneybox.data.wallet.local.WalletEntity
import kotlinx.coroutines.flow.Flow

class WalletDataSource(private val dao: WalletDao) {

    fun getWalletData(): Flow<WalletEntity> = dao.getWalletData()

}