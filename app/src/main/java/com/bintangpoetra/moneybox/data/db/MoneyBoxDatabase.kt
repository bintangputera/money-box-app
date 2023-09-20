package com.bintangpoetra.moneybox.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.bintangpoetra.moneybox.R
import com.bintangpoetra.moneybox.data.category.local.CategoryDao
import com.bintangpoetra.moneybox.data.category.local.CategoryEntity
import com.bintangpoetra.moneybox.data.savings.local.SavingsDao
import com.bintangpoetra.moneybox.data.savings.local.SavingsEntity
import com.bintangpoetra.moneybox.data.wallet.local.WalletDao
import com.bintangpoetra.moneybox.data.wallet.local.WalletEntity
import com.bintangpoetra.moneybox.domain.wallet.model.Wallet
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

@Database(
    entities = [CategoryEntity::class, SavingsEntity::class, WalletEntity::class],
    version = 2,
    exportSchema = false
)
abstract class MoneyBoxDatabase: RoomDatabase() {

    abstract fun categoryDao(): CategoryDao

    abstract fun savingsDao(): SavingsDao

    abstract fun walletDao(): WalletDao

}

private fun loadJSONArray(context: Context):JSONArray {
    val inputStream = context.resources.openRawResource(R.raw.wallet)

    BufferedReader(inputStream.reader()).use {
        return JSONArray(it.readText())
    }
}

suspend fun fillWalletData(context: Context, dao: WalletDao) {
    val wallet = loadJSONArray(context)
    try {
        for (i in 0 until wallet.length()) {
            val item = wallet.getJSONObject(i)
            dao.newWallet(
                WalletEntity(
                    id = 0,
                    walletName = item.getString("wallet_name"),
                    initialNominal = item.getInt("initialNominal"),
                    description = item.getString("description")
                )
            )
        }
    } catch (exception: JSONException) {
        exception.printStackTrace()
    }
}