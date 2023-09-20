package com.bintangpoetra.moneybox.di.feature

import com.bintangpoetra.moneybox.data.savings.SavingDataStore
import com.bintangpoetra.moneybox.data.savings.SavingRepository
import com.bintangpoetra.moneybox.data.savings.source.SavingsDataSource
import com.bintangpoetra.moneybox.domain.saving.SavingInteractor
import com.bintangpoetra.moneybox.domain.saving.SavingUseCase
import com.bintangpoetra.moneybox.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val savingModule = module {

    single { SavingsDataSource(get()) }
    factory<SavingUseCase> { SavingInteractor(get()) }
    factory<SavingRepository> { SavingDataStore(get()) }

    single { SavingDataStore(get()) }
    single { SavingInteractor(get()) }

}