package com.bintangpoetra.moneybox.data.savings.source

import com.bintangpoetra.moneybox.data.savings.local.SavingsDao
import com.bintangpoetra.moneybox.data.savings.local.SavingsEntity
import kotlinx.coroutines.flow.Flow

class SavingsDataSource(private val dao: SavingsDao) {

    fun getAllSavings(): Flow<List<SavingsEntity>> = dao.getAllSavings()

    fun getAllSavingsByDate(date: String): Flow<List<SavingsEntity>> = dao.getAllSavingByDate(date)

    fun getTotal(type: String, date: String): Flow<Int?> = dao.getTotal(type, date)

    suspend fun addNewSaving(savingsEntity: SavingsEntity) {
        dao.addNewSaving(savingsEntity)
    }

    suspend fun deleteSaving(id: Int) {
        dao.deleteSaving(id)
    }

}