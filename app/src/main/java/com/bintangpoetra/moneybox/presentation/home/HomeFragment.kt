package com.bintangpoetra.moneybox.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bintangpoetra.moneybox.R
import com.bintangpoetra.moneybox.base.BaseFragment
import com.bintangpoetra.moneybox.data.lib.Result
import com.bintangpoetra.moneybox.databinding.FragmentHomeBinding
import com.bintangpoetra.moneybox.presentation.home.adapter.TransactionAdapter
import com.bintangpoetra.moneybox.utils.extension.hide
import com.bintangpoetra.moneybox.utils.extension.show
import com.bintangpoetra.moneybox.utils.extension.showConfirmDialog
import com.bintangpoetra.moneybox.utils.extension.showToast
import com.bintangpoetra.moneybox.utils.helper.DateHelper
import org.koin.android.ext.android.inject

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val homeViewModel: HomeViewModel by inject()

    private val monthAndYear = "%${DateHelper().getCurrentMonthAndYear()}%"
    private val monthName = DateHelper().getMonthName()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
        binding.apply {
            rvTransaction.apply {
                layoutManager = LinearLayoutManager(context)
            }
            tvTransactionLabel.text = "Catatan Keuangan Bulan $monthName"
        }
    }

    override fun initAction() {
        binding.apply {
            btnNewSavings.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_addSavingFragment)
            }
        }
    }

    override fun initProcess() {
        refreshData()
    }

    override fun initObservers() {
        homeViewModel.savingsData.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Loading -> {
                }

                is Result.Success -> {
                    binding.rvTransaction.show()
                    val adapter = TransactionAdapter(result.data, onClick = {
                        showConfirmDialog(
                            "Informasi",
                            "Apakah yakin ingin menghapus catatan ini ?",
                            onPositiveClick = {
                                deleteSaving(it.id)
                                refreshData()
                            })
                    })
                    binding.rvTransaction.adapter = adapter
                }

                is Result.Empty -> {
                    binding.rvTransaction.hide()
                }

                else -> {}
            }
        }
        homeViewModel.totalExpenses.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Success -> {
                    binding.tvExpense.text = "Rp. ${result.data}"
                }

                is Result.Empty -> {
                    binding.tvExpense.text = "Rp. 0"
                }

                else -> {}
            }
        }
        homeViewModel.totalIncome.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Success -> {
                    binding.tvIncome.text = "Rp. ${result.data}"
                }

                is Result.Empty -> {
                    binding.tvIncome.text = "Rp. 0"
                }

                else -> {}
            }
        }
        homeViewModel.walletData.observe(viewLifecycleOwner) { result ->
            when(result) {
                is Result.Success -> {
                    binding.apply {
                        tvBalance.text = "Rp. ${result.data.initialNominal}"
                    }
                }
                else -> {}
            }
        }
    }

    override fun onResume() {
        super.onResume()
        refreshData()
    }

    private fun deleteSaving(id: Int) {
        homeViewModel.deleteSaving(id)
    }

    private fun refreshData() {
        homeViewModel.getWalletData()
        homeViewModel.getAllSavings(monthAndYear)
        homeViewModel.getTotalExpenses(monthAndYear)
        homeViewModel.getTotalIncomes(monthAndYear)
    }

}