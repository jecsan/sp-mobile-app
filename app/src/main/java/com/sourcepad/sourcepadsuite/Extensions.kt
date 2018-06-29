package com.sourcepad.sourcepadsuite

import android.view.View
import android.widget.ProgressBar
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

fun View.setLoadingStatus(status: Boolean, progressBar: ProgressBar? = null) {
    if (status) {
        progressBar?.visibility = View.VISIBLE
        this.isEnabled = false
        this.alpha = 0.7f
    } else {
        progressBar?.visibility = View.INVISIBLE
        this.isEnabled = true
        this.alpha = 1f
    }

}


fun Date.getFullDate(): String {
    return DateFormat.getDateInstance(DateFormat.FULL, Locale.US).format(this)
}

fun Date.getLongDate(): String {
    return DateFormat.getDateInstance(DateFormat.LONG, Locale.US).format(this)
}

fun Date.getShortDate(): String {
    return DateFormat.getDateInstance(DateFormat.SHORT, Locale.US).format(this)
}

fun Date.getTimeString(): String {
    return DateFormat.getTimeInstance(DateFormat.SHORT, Locale.US).format(this)
}

fun gcDateFormatterForAPI(): SimpleDateFormat {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    dateFormat.timeZone = TimeZone.getDefault()
    return dateFormat
}