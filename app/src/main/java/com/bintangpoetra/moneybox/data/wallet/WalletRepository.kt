package com.bintangpoetra.moneybox.data.wallet

import com.bintangpoetra.moneybox.domain.wallet.model.Wallet
import kotlinx.coroutines.flow.Flow
import com.bintangpoetra.moneybox.data.lib.Result

interface WalletRepository {

    fun getWalletData(): Flow<Result<Wallet>>

}