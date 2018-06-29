package com.sourcepad.sourcepadsuite.presentation.commendation

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.sourcepad.sourcepadsuite.data.api.SpApi
import com.sourcepad.sourcepadsuite.presentation.CommendationState
import com.sourcepad.sourcepadsuite.presentation.Source
import com.sourcepad.sourcepadsuite.presentation.State
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CommendationViewModel @Inject constructor(private val spApi: SpApi): ViewModel() {

    val mutableData = MutableLiveData<CommendationState>()

    fun getCommendations() {
        spApi.getCommendations().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mutableData.value = CommendationState(State.SUCCESS, it.commendations, Source.REMOTE)
                }, {
                    mutableData.value = CommendationState(State.FAILED)
                    it.printStackTrace()
                })
    }
}