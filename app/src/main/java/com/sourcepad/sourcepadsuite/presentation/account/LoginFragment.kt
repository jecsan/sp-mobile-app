package com.sourcepad.sourcepadsuite.presentation.account

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.common.SignInButton
import com.sourcepad.sourcepadsuite.R
import com.sourcepad.sourcepadsuite.presentation.MainActivity
import com.sourcepad.sourcepadsuite.presentation.State
import com.sourcepad.sourcepadsuite.setLoadingStatus
import com.sourcepad.suite.di.viewmodels.ViewModelFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

class LoginFragment : DaggerFragment() {

    @Inject
    lateinit var modelFactory: ViewModelFactory

    private lateinit var vm: LoginViewModel


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        vm = modelFactory.create(LoginViewModel::class.java)
        vm.mutableData.observe(this, Observer {
            when (it?.state) {

                State.SUCCESS -> {
                    signInBtn.setLoadingStatus(false, progressBar)
                    activity?.finish()
                    startActivity(Intent(context, MainActivity::class.java))
                }

                State.LOADING -> {
                    signInBtn.setLoadingStatus(true, progressBar)

                }
                State.FAILED -> {
                    signInBtn.setLoadingStatus(false, progressBar)
                    Snackbar.make(spLogoIv, "Unable to login, please try again", Snackbar.LENGTH_LONG).show()
                }
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        signInBtn.setSize(SignInButton.SIZE_WIDE)
        signInBtn.setOnClickListener {
            vm.login()
        }
    }
}