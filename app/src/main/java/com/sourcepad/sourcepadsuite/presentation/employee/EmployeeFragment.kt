package com.sourcepad.sourcepadsuite.presentation.employee

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sourcepad.sourcepadsuite.R
import com.sourcepad.sourcepadsuite.presentation.model.EmployeeUiModel
import kotlinx.android.synthetic.main.fragment_list.*

class EmployeeFragment : Fragment() {

    private lateinit var adapter: EmployeeAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = EmployeeAdapter().apply {
            this.items = ArrayList<EmployeeUiModel>().apply {
                for (i in 0..20) {
                    add(EmployeeUiModel("Jose Edwin Santiago", "Android Developer", "sdgdgdfg"))
                }
            }
        }

        adapter.onClickSubject.subscribe {
            startActivity(Intent(context, EmployeeDetailActivity::class.java))
        }


        recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter
    }
}