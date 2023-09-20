package com.bintangpoetra.moneybox.presentation.home.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bintangpoetra.moneybox.databinding.SavingItemBinding
import com.bintangpoetra.moneybox.domain.saving.model.Saving

class TransactionAdapter(private val list: List<Saving>, private val onClick: (Saving) -> Unit): RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SavingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        list[position].let {
            holder.bind(it)
        }
    }

    inner class ViewHolder(private val binding: SavingItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(saving: Saving) {
            binding.apply {
                tvNotes.text = saving.notes
                tvDate.text = saving.date

                if (saving.type == "keluar") {
                    tvNominal.setTextColor(Color.parseColor("#ff0000"))
                    tvNominal.text = "- Rp.${saving.nominal}"
                } else {
                    tvNominal.setTextColor(Color.parseColor("#00a827"))
                    tvNominal.text = "+ Rp.${saving.nominal}"
                }

                root.setOnClickListener {
                    onClick.invoke(saving)
                }
            }
        }
    }

}