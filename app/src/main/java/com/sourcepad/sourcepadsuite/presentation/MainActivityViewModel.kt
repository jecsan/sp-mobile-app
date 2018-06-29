package com.sourcepad.suite.presentation

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.sourcepad.suite.data.Api
import okhttp3.OkHttpClient
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(val okHttpClient: OkHttpClient, val api : Api) : ViewModel() {


    fun workingYay(){
        Log.d("Test","Working $api $okHttpClient")
    }
}