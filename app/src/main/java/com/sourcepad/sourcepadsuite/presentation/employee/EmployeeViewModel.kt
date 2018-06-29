package com.sourcepad.sourcepadsuite.presentation.employee

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.sourcepad.sourcepadsuite.data.api.SpApi
import com.sourcepad.sourcepadsuite.presentation.EmployeeState
import com.sourcepad.sourcepadsuite.presentation.Source
import com.sourcepad.sourcepadsuite.presentation.State
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class EmployeeViewModel @Inject constructor(private val spApi: SpApi) : ViewModel() {

    val mutableData = MutableLiveData<EmployeeState>()

    fun getEmployees() {
        spApi.getEmployees().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mutableData.value = EmployeeState(State.SUCCESS, it.users, Source.REMOTE)
                }, {
                    mutableData.value = EmployeeState(State.FAILED)
                    it.printStackTrace()
                })
    }
}