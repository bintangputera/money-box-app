package com.bintangpoetra.moneybox.di.feature

import com.bintangpoetra.moneybox.presentation.home.HomeViewModel
import com.bintangpoetra.moneybox.presentation.savings.add.AddSavingViewModel
import com.bintangpoetra.moneybox.presentation.wallet.WalletViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { HomeViewModel(get(), get()) }

    viewModel { AddSavingViewModel(get()) }

    viewModel { WalletViewModel(get()) }

}