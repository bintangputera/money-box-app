package com.bintangpoetra.moneybox.presentation.wallet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bintangpoetra.moneybox.domain.wallet.WalletUseCase
import com.bintangpoetra.moneybox.domain.wallet.model.Wallet
import com.bintangpoetra.moneybox.data.lib.Result
import kotlinx.coroutines.launch

class WalletViewModel(
    private val walletUseCase: WalletUseCase
): ViewModel() {

    private val _walletData = MutableLiveData<Result<Wallet>>()
    val walletData: LiveData<Result<Wallet>> by lazy { _walletData }

    fun getWalletData() {
        viewModelScope.launch {
            walletUseCase.getWalletData().collect {
                _walletData.value = it
            }
        }
    }

}