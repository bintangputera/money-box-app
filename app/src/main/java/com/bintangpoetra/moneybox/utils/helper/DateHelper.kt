package com.bintangpoetra.moneybox.utils.helper

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class DateHelper {

    fun getCurrentMonthAndYear(): String? {
        val format = "MM/yy"
        val dateFormat = SimpleDateFormat(format, Locale.US)
        return dateFormat.format(Calendar.getInstance().time)
    }

    fun getMonthName(): String {
        val format = "MMMM"
        val dateFormat = SimpleDateFormat(format, Locale("id"))
        return dateFormat.format(Calendar.getInstance().time)
    }

}