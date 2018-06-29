package com.sourcepad.sourcepadsuite.presentation.account

import android.accounts.Account
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.greyblocks.gatekeeper.GateKeeper
import com.sourcepad.sourcepadsuite.data.api.SpApi
import com.sourcepad.sourcepadsuite.presentation.LoginState
import com.sourcepad.sourcepadsuite.presentation.State
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val spApi: SpApi, private val gateKeeper: GateKeeper) : ViewModel() {

    val mutableData: MutableLiveData<LoginState> = MutableLiveData<LoginState>().also {
        it.value = LoginState(State.DEFAULT, null)
    }

    fun login() {
        spApi.login("mobile2@sourcepad.com")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val user = it.user
                    gateKeeper.login(Account(user.attributes.email, "sp_suite"), null, user.attributes.accessToken!!)
                    gateKeeper.saveUserData(Key.ID, user.id ?: "")
                    gateKeeper.saveUserData(Key.SSO_TOKEN, user.attributes.ssoToken ?: "")
                    gateKeeper.saveUserData(Key.NAME, user.attributes.name ?: "")
                    mutableData.value = LoginState(State.SUCCESS,user)
                }, {
                    mutableData.value = LoginState(State.FAILED)
                    it.printStackTrace()
                })
    }
}