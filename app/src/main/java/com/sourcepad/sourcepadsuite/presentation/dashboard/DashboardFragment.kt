package com.sourcepad.sourcepadsuite.presentation.dashboard

import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sourcepad.sourcepadsuite.R
import com.sourcepad.sourcepadsuite.data.api.User
import com.sourcepad.sourcepadsuite.presentation.State
import com.sourcepad.suite.di.viewmodels.ViewModelFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_dashboard.*
import javax.inject.Inject

class DashboardFragment : DaggerFragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    @Inject
    lateinit var modelFactory: ViewModelFactory


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        dashboardViewModel = modelFactory.create(DashboardViewModel::class.java)
        dashboardViewModel.mutableData.observe(this, Observer {
            when (it?.state) {
                State.DEFAULT -> {
                    initDashboard(it.user)
                }
            }
        })
    }


    private fun initDashboard(user: User?) {
        user?.apply {
            dashboardWelcomeMsgTv.text = Html.fromHtml("Hello <b>${user.name}</b>, Welcome to your dashboard.")
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }
}