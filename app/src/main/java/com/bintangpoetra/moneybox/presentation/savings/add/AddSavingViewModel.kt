package com.bintangpoetra.moneybox.presentation.savings.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bintangpoetra.moneybox.domain.saving.SavingUseCase
import com.bintangpoetra.moneybox.domain.saving.model.Saving
import kotlinx.coroutines.launch

class AddSavingViewModel(
    private val savingUseCase: SavingUseCase
): ViewModel() {

    fun addNewSaving(saving: Saving) {
        viewModelScope.launch {
            savingUseCase.addNewSaving(saving)
        }
    }

}