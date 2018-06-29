package com.sourcepad.sourcepadsuite

import android.view.View
import android.widget.ProgressBar

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