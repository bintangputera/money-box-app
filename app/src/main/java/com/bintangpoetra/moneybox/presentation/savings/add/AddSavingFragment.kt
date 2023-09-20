package com.bintangpoetra.moneybox.presentation.savings.add

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bintangpoetra.moneybox.base.BaseFragment
import com.bintangpoetra.moneybox.databinding.FragmentAddSavingBinding
import com.bintangpoetra.moneybox.domain.saving.model.Saving
import org.koin.android.ext.android.inject
import java.text.SimpleDateFormat
import java.util.Locale

class AddSavingFragment : BaseFragment<FragmentAddSavingBinding>() {

    private val addSavingViewModel: AddSavingViewModel by inject()

    private val calendar = Calendar.getInstance()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentAddSavingBinding = FragmentAddSavingBinding.inflate(inflater, container, false)

    override fun initIntent() {
    }

    override fun initUI() {
    }

    override fun initAction() {
        val date = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateCalendar()
        }
        binding.apply {
            edtDate.setOnClickListener {
                DatePickerDialog(
                    requireContext(),
                    date,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
            fabSave.setOnClickListener {
                addNewSavings()
                findNavController().popBackStack()
            }
            toolbar.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    override fun initProcess() {
    }

    override fun initObservers() {
    }

    private fun updateCalendar() {
        val format = "dd/MM/yy"
        val dateFormat = SimpleDateFormat(format, Locale.US)
        binding.edtDate.setText(dateFormat.format(calendar.time))
    }

    private fun addNewSavings() {
        val savingNominal = binding.edtNominal.text.toString()
        val savingCategory = binding.spinnerCategory.selectedItem
        val savingNote = binding.edtNotes.text.toString()
        val savingDate = binding.edtDate.text.toString()

        val savings = Saving(
            id = 0,
            nominal = savingNominal.toInt(),
            type = "masuk",
            notes = savingNote,
            date = savingDate
        )
        addSavingViewModel.addNewSaving(savings)
    }

}