package com.sourcepad.suite.presentation

import android.arch.lifecycle.ViewModel
import okhttp3.OkHttpClient
import javax.inject.Inject

class DetailFragmentViewModel @Inject constructor(val okHttpClient: OkHttpClient) : ViewModel() {
}