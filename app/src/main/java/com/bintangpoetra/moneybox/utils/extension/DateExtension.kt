package com.bintangpoetra.moneybox.utils.extension

import android.widget.DatePicker
import java.util.Calendar
import java.util.Date

fun DatePicker.getDate(): Date {
    val calendar = Calendar.getInstance()
    calendar.set(year, month, dayOfMonth)
    return calendar.time
}