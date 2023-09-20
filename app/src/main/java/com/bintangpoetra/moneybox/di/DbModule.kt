package com.bintangpoetra.moneybox.di

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.bintangpoetra.moneybox.data.db.MoneyBoxDatabase
import com.bintangpoetra.moneybox.data.db.fillWalletData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

const val DB_NAME: String = "moneybox-database"

val dbModule = module {

    factory { get<MoneyBoxDatabase>().categoryDao() }

    factory { get<MoneyBoxDatabase>().savingsDao() }

    factory { get<MoneyBoxDatabase>().walletDao() }

    single {
        Room.databaseBuilder(androidApplication(), MoneyBoxDatabase::class.java, DB_NAME)
            .fallbackToDestructiveMigration()
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)

                    CoroutineScope(Dispatchers.IO).launch {
                        fillWalletData(androidContext(), get<MoneyBoxDatabase>().walletDao())
                    }
                }
            })
            .build()
    }

}
