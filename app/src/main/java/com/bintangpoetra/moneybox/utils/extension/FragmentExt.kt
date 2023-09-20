package com.bintangpoetra.moneybox.utils.extension

import android.app.AlertDialog
import androidx.fragment.app.Fragment

fun Fragment.showConfirmDialog(
    title: String,
    message: String,
    onPositiveClick:() -> Unit
){
    AlertDialog.Builder(requireContext()).apply {
        setTitle(title)
        setMessage(message)
        setNegativeButton("Batal") { p0, _ ->
            p0.dismiss()
        }
        setPositiveButton("Ya") { _, _ ->
            onPositiveClick()
        }
    }.create().show()
}