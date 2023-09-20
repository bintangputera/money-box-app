package com.bintangpoetra.moneybox.domain.wallet

import com.bintangpoetra.moneybox.data.lib.Result
import com.bintangpoetra.moneybox.data.wallet.WalletRepository
import com.bintangpoetra.moneybox.domain.wallet.model.Wallet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class WalletInteractor(
    private val repository: WalletRepository
): WalletUseCase {

    override fun getWalletData(): Flow<Result<Wallet>> {
        return repository.getWalletData()
            .flowOn(Dispatchers.IO)
    }

}