package com.bintangpoetra.moneybox.base

import android.app.Application
import com.bintangpoetra.moneybox.di.dbModule
import com.bintangpoetra.moneybox.di.feature.categoryModule
import com.bintangpoetra.moneybox.di.feature.savingModule
import com.bintangpoetra.moneybox.di.feature.viewModelModule
import com.bintangpoetra.moneybox.di.feature.walletModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@BaseApplication)
            modules(
                listOf(
                    categoryModule,
                    savingModule,
                    walletModule,
                    viewModelModule,
                    dbModule
                )
            )
        }
    }


}