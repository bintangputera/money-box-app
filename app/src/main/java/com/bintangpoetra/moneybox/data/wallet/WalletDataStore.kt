package com.bintangpoetra.moneybox.data.wallet

import com.bintangpoetra.moneybox.data.wallet.source.WalletDataSource
import com.bintangpoetra.moneybox.domain.wallet.model.Wallet
import com.bintangpoetra.moneybox.data.lib.Result
import com.bintangpoetra.moneybox.domain.wallet.mapper.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WalletDataStore(
    private val db: WalletDataSource
) : WalletRepository {

    override fun getWalletData(): Flow<Result<Wallet>> = flow {
        db.getWalletData().collect { walletData ->
            try {
                emit(Result.Loading)

                emit(Result.Success(walletData.toDomain()))
            } catch (ex: Exception) {
                emit(Result.Error(ex.message.toString()))
            }
        }
    }

}