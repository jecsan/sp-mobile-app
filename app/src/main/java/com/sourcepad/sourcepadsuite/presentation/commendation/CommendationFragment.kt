package com.sourcepad.sourcepadsuite.presentation.commendation

import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sourcepad.sourcepadsuite.R
import com.sourcepad.sourcepadsuite.presentation.State
import com.sourcepad.sourcepadsuite.presentation.model.CommendationUiModel
import com.sourcepad.suite.di.viewmodels.ViewModelFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class CommendationFragment : DaggerFragment() {

    @Inject
    lateinit var modelFactory: ViewModelFactory
    private lateinit var vm : CommendationViewModel
    private lateinit var adapter : CommendationAdapter

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        vm = modelFactory.create(CommendationViewModel::class.java)
        vm.mutableData.observe(this, Observer {
            when (it?.state) {
                State.SUCCESS -> {
                    swipeRefresh?.isRefreshing = false
                    adapter.items = it.user?.map {
                        CommendationUiModel(it.id,
                                it.type.capitalize(),
                                it.attributes.from,
                                it.attributes.to,
                                it.attributes.message?: "No message",
                                it.attributes.date) } ?: emptyList()
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



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CommendationAdapter()
        recyclerView.adapter =adapter
        swipeRefresh.setOnRefreshListener {
            vm.getCommendations()
        }
        vm.getCommendations()
//                CommendationAdapter().apply {
//            this.items = ArrayList<CommendationUiModel>().apply {
//                for (i in 0..20) {
//                    add(CommendationUiModel(1, "Shout-out", "girltester",
//                            "boytester", " Helping out golfcrow", "06-30-2018"))
//
//                }
//            }
//        }
    }
}