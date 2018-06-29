package com.sourcepad.sourcepadsuite.presentation.employee

import android.app.Activity
import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sourcepad.sourcepadsuite.R
import com.sourcepad.sourcepadsuite.presentation.State
import com.sourcepad.sourcepadsuite.presentation.model.EmployeeUiModel
import com.sourcepad.suite.di.viewmodels.ViewModelFactory
import com.tbruyelle.rxpermissions2.RxPermissions
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class EmployeeFragment : DaggerFragment() {

    @Inject
    lateinit var modelFactory: ViewModelFactory

    private lateinit var adapter: EmployeeAdapter
    private lateinit var vm: EmployeeViewModel

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        vm = modelFactory.create(EmployeeViewModel::class.java)
        vm.mutableData.observe(this, Observer {
            when (it?.state) {
                State.SUCCESS -> {
                    swipeRefresh?.isRefreshing = false
                    adapter.items = it.user?.map {
                        EmployeeUiModel(it.id,
                                it.attributes.name ?: "",
                                it.attributes.position ?: "",
                                it.attributes.mobileNumber?:"",
                                "",
                                it.attributes.skype?:"",
                                it.attributes.tinNumber?:"",
                                it.attributes.sssNumber?:"",
                                it.attributes.startDate?:"",
                                it.attributes.idNumber.toString(),
                                it.attributes.address?:"")
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

    private fun call(phoneNumber:String){
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$phoneNumber"))
        startActivity(intent)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = EmployeeAdapter()
        adapter.onCallSubject.subscribe { model->
            RxPermissions(activity as Activity).request(android.Manifest.permission.CALL_PHONE)
                    .subscribe {
                        if(it)call(model.phoneNumber)
                    }

        }

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