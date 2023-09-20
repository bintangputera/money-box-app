package com.bintangpoetra.moneybox.di.feature

import com.bintangpoetra.moneybox.data.wallet.WalletDataStore
import com.bintangpoetra.moneybox.data.wallet.WalletRepository
import com.bintangpoetra.moneybox.data.wallet.source.WalletDataSource
import com.bintangpoetra.moneybox.domain.wallet.WalletInteractor
import com.bintangpoetra.moneybox.domain.wallet.WalletUseCase
import org.koin.dsl.module

val walletModule = module {

    single { WalletDataSource(get()) }
    factory<WalletUseCase> { WalletInteractor(get()) }
    factory<WalletRepository> { WalletDataStore(get()) }

    single { WalletDataStore(get()) }
    single { WalletInteractor(get()) }

}