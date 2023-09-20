package com.bintangpoetra.moneybox.presentation.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bintangpoetra.moneybox.base.BaseFragment
import com.bintangpoetra.moneybox.databinding.FragmentSettingsBinding

class SettingsFragment: BaseFragment<FragmentSettingsBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentSettingsBinding = FragmentSettingsBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
    }

    override fun initAction() {
    }

    override fun initProcess() {
    }

    override fun initObservers() {
    }

}