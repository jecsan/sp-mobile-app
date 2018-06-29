package com.sourcepad.sourcepadsuite.presentation.dashboard

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.greyblocks.gatekeeper.GateKeeper
import com.sourcepad.sourcepadsuite.data.api.User
import com.sourcepad.sourcepadsuite.presentation.LoginState
import com.sourcepad.sourcepadsuite.presentation.State
import com.sourcepad.sourcepadsuite.presentation.UserState
import com.sourcepad.sourcepadsuite.presentation.account.Key
import javax.inject.Inject

class DashboardViewModel @Inject constructor(private val gateKeeper: GateKeeper) : ViewModel() {
    val mutableData: MutableLiveData<LoginState> = MutableLiveData<LoginState>().also {
        it.value = LoginState(State.DEFAULT, null)
    }

    init {

        val user = User().apply {
            this.name = gateKeeper.getUserData(Key.NAME)
            mutableData.value = LoginState(State.DEFAULT, this)
        }

    }

}