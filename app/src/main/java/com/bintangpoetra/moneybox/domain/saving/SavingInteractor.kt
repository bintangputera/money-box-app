package com.bintangpoetra.moneybox.domain.saving

import com.bintangpoetra.moneybox.data.lib.Result
import com.bintangpoetra.moneybox.data.savings.SavingRepository
import com.bintangpoetra.moneybox.domain.saving.model.Saving
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class SavingInteractor(
    private val repository: SavingRepository
): SavingUseCase {

    override fun getAllSavings(): Flow<Result<List<Saving>>> {
        return repository.getAllSavings()
            .flowOn(Dispatchers.IO)
    }

    override fun getTotal(type: String, date: String): Flow<Result<Int>> {
        return repository.getTotal(type, date)
            .flowOn(Dispatchers.IO)
    }

    override fun getAllSavingByDate(date: String): Flow<Result<List<Saving>>> {
        return repository.getAllSavingByDate(date)
            .flowOn(Dispatchers.IO)
    }

    override suspend fun addNewSaving(saving: Saving) {
        return repository.addNewSaving(saving)
    }

    override suspend fun deleteSaving(id: Int) {
        return repository.deleteSaving(id)
    }

}