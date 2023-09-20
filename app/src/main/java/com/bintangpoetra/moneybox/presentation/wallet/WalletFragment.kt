package com.bintangpoetra.moneybox.presentation.wallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bintangpoetra.moneybox.base.BaseFragment
import com.bintangpoetra.moneybox.data.lib.Result
import com.bintangpoetra.moneybox.databinding.FragmentWalletBinding
import org.koin.android.ext.android.inject

class WalletFragment: BaseFragment<FragmentWalletBinding>() {

    private val walletViewModel: WalletViewModel by inject()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentWalletBinding = FragmentWalletBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
    }

    override fun initAction() {
    }

    override fun initProcess() {
        walletViewModel.getWalletData()
    }

    override fun initObservers() {
        walletViewModel.walletData.observe(viewLifecycleOwner) { result ->
            when(result) {
                is Result.Success -> {
                    binding.apply {
                        tvBalance.text = "Rp. ${result.data.initialNominal}"
                        tvLabelWallet.text = result.data.walletName
                    }
                }
                else -> {}
            }
        }
    }

}