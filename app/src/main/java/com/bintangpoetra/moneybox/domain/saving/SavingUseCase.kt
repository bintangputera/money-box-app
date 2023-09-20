package com.bintangpoetra.moneybox.domain.saving

import com.bintangpoetra.moneybox.data.lib.Result
import com.bintangpoetra.moneybox.domain.saving.model.Saving
import kotlinx.coroutines.flow.Flow

interface SavingUseCase {

    fun getAllSavings(): Flow<Result<List<Saving>>>

    fun getTotal(type: String, date: String): Flow<Result<Int>>

    fun getAllSavingByDate(date: String): Flow<Result<List<Saving>>>

    suspend fun addNewSaving(saving: Saving)

    suspend fun deleteSaving(id: Int)

}