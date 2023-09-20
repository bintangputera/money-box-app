package com.bintangpoetra.moneybox.data.savings

import com.bintangpoetra.moneybox.domain.saving.model.Saving
import com.bintangpoetra.moneybox.data.lib.Result
import com.bintangpoetra.moneybox.data.savings.local.SavingsEntity
import kotlinx.coroutines.flow.Flow

interface SavingRepository {

    fun getAllSavings(): Flow<Result<List<Saving>>>

    fun getTotal(type: String, date: String): Flow<Result<Int>>

    fun getAllSavingByDate(date: String): Flow<Result<List<Saving>>>

    suspend fun addNewSaving(saving: Saving)

    suspend fun deleteSaving(id: Int)

}