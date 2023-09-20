package com.bintangpoetra.moneybox.domain.wallet

import com.bintangpoetra.moneybox.data.lib.Result
import com.bintangpoetra.moneybox.domain.wallet.model.Wallet
import kotlinx.coroutines.flow.Flow

interface WalletUseCase {

    fun getWalletData(): Flow<Result<Wallet>>

}