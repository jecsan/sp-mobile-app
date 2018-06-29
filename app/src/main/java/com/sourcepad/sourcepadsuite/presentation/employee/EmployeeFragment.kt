package com.sourcepad.sourcepadsuite.presentation.employee

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sourcepad.sourcepadsuite.R
import com.sourcepad.sourcepadsuite.presentation.State
import com.sourcepad.sourcepadsuite.presentation.model.EmployeeUiModel
import com.sourcepad.suite.di.viewmodels.ViewModelFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class EmployeeFragment : DaggerFragment() {

    @Inject
    lateinit var modelFactory: ViewModelFactory

    private lateinit var vm: EmployeeViewModel

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        vm = modelFactory.create(EmployeeViewModel::class.java)
        vm.mutableData.observe(this, Observer {
            when (it?.state) {
                State.SUCCESS -> {
                    swipeRefresh?.isRefreshing = false
                    adapter.items = it.user?.map {
                        EmployeeUiModel(it.id ?: "",
                                it.attributes.name ?: "", it.attributes.position ?: "", "")
                    } ?: emptyList()
                }
                State.LOADING -> {
                    swipeRefresh?.isRefreshing = true

                }
                State.FAILED -> {
                    swipeRefresh?.isRefreshing = false
                }
                else -> {
                }
            }
        })
    }

    private lateinit var adapter: EmployeeAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = EmployeeAdapter()

        adapter.onClickSubject.subscribe {
            startActivity(Intent(context, EmployeeDetailActivity::class.java))
        }
        swipeRefresh?.post {
            swipeRefresh.isRefreshing = true
        }
        swipeRefresh?.setOnRefreshListener {
            vm.getEmployees()
        }

        vm.getEmployees()
        recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter
    }
}