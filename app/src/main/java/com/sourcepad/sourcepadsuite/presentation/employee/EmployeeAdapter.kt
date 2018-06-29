package com.sourcepad.sourcepadsuite.presentation.employee

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sourcepad.sourcepadsuite.R
import com.sourcepad.sourcepadsuite.presentation.BaseRecyclerAdapter
import com.sourcepad.sourcepadsuite.presentation.model.EmployeeUiModel
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item_employee.view.*

class EmployeeAdapter : BaseRecyclerAdapter<EmployeeUiModel>() {

    val onCallSubject: PublishSubject<EmployeeUiModel> = PublishSubject.create<EmployeeUiModel>()
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BaseViewHolder {
        return BaseViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_employee, p0, false))
    }

    override fun onBindViewHolder(p0: BaseViewHolder, p1: Int) {
        val item = getItem(p1)
        p0.itemView.callIb.setOnClickListener {
            onCallSubject.onNext(item)
        }
        
        p0.itemView.apply {
            nameTv.text = item.name
            titleTv.text = item.title
            //TODO load image?

            setOnClickListener {
                onClickSubject.onNext(item)
            }
        }
    }
}