package com.bintangpoetra.moneybox.data.wallet.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WalletDao {

    @Query("SELECT * FROM wallet WHERE id=1")
    fun getWalletData(): Flow<WalletEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun newWallet(walletEntity: WalletEntity)

}