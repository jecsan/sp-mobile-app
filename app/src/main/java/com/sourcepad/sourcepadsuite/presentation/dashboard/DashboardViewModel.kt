package com.sourcepad.sourcepadsuite.presentation.dashboard

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.greyblocks.gatekeeper.GateKeeper
import com.sourcepad.sourcepadsuite.data.account.MyUser
import com.sourcepad.sourcepadsuite.presentation.MyUserState
import com.sourcepad.sourcepadsuite.presentation.State
import com.sourcepad.sourcepadsuite.presentation.account.Key
import javax.inject.Inject

class DashboardViewModel @Inject constructor(private val gateKeeper: GateKeeper) : ViewModel() {
    val mutableData: MutableLiveData<MyUserState> = MutableLiveData<MyUserState>().also {
        it.value = MyUserState(State.DEFAULT, null)
    }

    init {

        val user = MyUser(gateKeeper.getUserData(Key.NAME),gateKeeper.getUserData(Key.ID)?:"").apply {
            mutableData.value = MyUserState(State.DEFAULT, this)
        }

    }

}