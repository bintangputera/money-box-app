package com.bintangpoetra.moneybox.di.feature

import com.bintangpoetra.moneybox.data.category.CategoryDataStore
import com.bintangpoetra.moneybox.data.category.CategoryRepository
import com.bintangpoetra.moneybox.data.category.source.CategoryDataSource
import com.bintangpoetra.moneybox.data.savings.SavingDataStore
import com.bintangpoetra.moneybox.data.savings.SavingRepository
import com.bintangpoetra.moneybox.data.savings.source.SavingsDataSource
import com.bintangpoetra.moneybox.domain.category.CategoryInteractor
import com.bintangpoetra.moneybox.domain.category.CategoryUseCase
import com.bintangpoetra.moneybox.domain.saving.SavingInteractor
import com.bintangpoetra.moneybox.domain.saving.SavingUseCase
import org.koin.dsl.module

val categoryModule = module {

    single { CategoryDataSource(get()) }
    factory<CategoryUseCase> { CategoryInteractor(get()) }
    factory<CategoryRepository> { CategoryDataStore(get()) }

    single { CategoryDataStore(get()) }
    single { CategoryInteractor(get()) }

}