package com.bintangpoetra.moneybox.data.savings.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.bintangpoetra.moneybox.domain.saving.model.Saving
import kotlinx.coroutines.flow.Flow

@Dao
interface SavingsDao {

    @Query("SELECT * FROM savings")
    fun getAllSavings(): Flow<List<SavingsEntity>>

    @Query("SELECT * FROM savings WHERE date LIKE :date")
    fun getAllSavingByDate(date: String): Flow<List<SavingsEntity>>

    @Query("SELECT SUM(nominal) FROM savings WHERE type=:type AND date LIKE :date")
    fun getTotal(type: String, date: String): Flow<Int?>

    @Insert(onConflict = IGNORE)
    suspend fun addNewSaving(savingsEntity: SavingsEntity)

    @Query("DELETE FROM savings WHERE id=:id")
    suspend fun deleteSaving(id: Int)

}