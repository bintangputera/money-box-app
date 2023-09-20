package com.bintangpoetra.moneybox.data.savings

import com.bintangpoetra.moneybox.data.savings.source.SavingsDataSource
import com.bintangpoetra.moneybox.domain.saving.mapper.toDomain
import com.bintangpoetra.moneybox.domain.saving.mapper.toEntity
import com.bintangpoetra.moneybox.domain.saving.model.Saving
import com.bintangpoetra.moneybox.data.lib.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SavingDataStore(
    private val db: SavingsDataSource
): SavingRepository {

    override fun getAllSavings(): Flow<Result<List<Saving>>> = flow {
        db.getAllSavings().collect { savingsData ->
            try {
                emit(Result.Loading)

                if (savingsData.isNotEmpty()) {
                    emit(Result.Success(savingsData.toDomain()))
                } else {
                    emit(Result.Empty)
                }
            } catch (ex: Exception) {
                emit(Result.Error(ex.message.toString()))
            }
        }
    }

    override fun getTotal(type: String, date: String): Flow<Result<Int>> = flow {
        db.getTotal(type, date).collect { total ->
            try {
                if (total != null) {
                    emit(Result.Success(total))
                } else {
                    emit(Result.Empty)
                }
            } catch (ex: Exception) {
                emit(Result.Error(ex.message.toString()))
            }
        }
    }

    override fun getAllSavingByDate(date: String): Flow<Result<List<Saving>>> = flow {
        db.getAllSavingsByDate(date).collect { savingsData ->
            try {
                emit(Result.Loading)

                if (savingsData.isNotEmpty()) {
                    emit(Result.Success(savingsData.toDomain()))
                } else {
                    emit(Result.Empty)
                }
            } catch (ex: Exception) {
                emit(Result.Error(ex.message.toString()))
            }
        }
    }

    override suspend fun addNewSaving(saving: Saving) {
        db.addNewSaving(saving.toEntity())
    }

    override suspend fun deleteSaving(id: Int) {
        db.deleteSaving(id)
    }

}