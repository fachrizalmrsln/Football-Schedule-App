package com.id.zul.submission5kade.utils

import java.text.SimpleDateFormat
import java.util.*

object Utils {
    fun formatToDate(date: Date): String {
        return SimpleDateFormat("EEEE, dd MMM yyy", Locale.getDefault()).format(date)
    }
}