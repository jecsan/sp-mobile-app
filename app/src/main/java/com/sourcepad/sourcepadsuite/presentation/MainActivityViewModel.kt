package com.sourcepad.suite.presentation

import android.app.Activity
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.greyblocks.gatekeeper.GateKeeper
import com.sourcepad.sourcepadsuite.data.api.SpApi
import okhttp3.OkHttpClient
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val okHttpClient: OkHttpClient, private val spApi: SpApi, private val gateKeeper: GateKeeper) : ViewModel() {


    fun workingYay() {
        Log.d("Test", "Working $spApi $okHttpClient")
    }

    fun checkAuth(activity: Activity) {
        gateKeeper.checkUserAuth(activity)
    }

    fun logout() {
        gateKeeper.logout()
    }
}