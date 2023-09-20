package com.bintangpoetra.moneybox.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bintangpoetra.moneybox.data.lib.Result
import com.bintangpoetra.moneybox.domain.saving.SavingUseCase
import com.bintangpoetra.moneybox.domain.saving.model.Saving
import com.bintangpoetra.moneybox.domain.wallet.WalletUseCase
import com.bintangpoetra.moneybox.domain.wallet.model.Wallet
import kotlinx.coroutines.launch

class HomeViewModel(
    private val savingUseCase: SavingUseCase,
    private val walletUseCase: WalletUseCase
): ViewModel() {

    private val _savingsData = MutableLiveData<Result<List<Saving>>>()
    val savingsData: LiveData<Result<List<Saving>>> by lazy { _savingsData }

    private val _totalExpenses = MutableLiveData<Result<Int>>()
    val totalExpenses: LiveData<Result<Int>> by lazy { _totalExpenses }

    private val _totalIncome = MutableLiveData<Result<Int>>()
    val totalIncome: LiveData<Result<Int>> by lazy { _totalIncome }

    private val _walletData = MutableLiveData<Result<Wallet>>()
    val walletData: LiveData<Result<Wallet>> by lazy { _walletData }

    fun getWalletData() {
        viewModelScope.launch {
            walletUseCase.getWalletData().collect {
                _walletData.value = it
            }
        }
    }

    fun getAllSavings(date: String) {
        viewModelScope.launch {
            savingUseCase.getAllSavingByDate(date)
                .collect {
                    _savingsData.value = it
                }
        }
    }

    fun getTotalExpenses(date: String) {
        viewModelScope.launch {
            savingUseCase.getTotal("keluar", date)
                .collect {
                    _totalExpenses.value = it
                }
        }
    }

    fun getTotalIncomes(date: String) {
        viewModelScope.launch {
            savingUseCase.getTotal("masuk", date)
                .collect {
                    _totalIncome.value = it
                }
        }
    }

    fun deleteSaving(id: Int) {
        viewModelScope.launch {
            savingUseCase.deleteSaving(id)
        }
    }

}