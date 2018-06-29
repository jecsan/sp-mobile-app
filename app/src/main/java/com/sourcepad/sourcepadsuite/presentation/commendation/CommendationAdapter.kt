package com.sourcepad.sourcepadsuite.presentation.commendation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sourcepad.sourcepadsuite.R
import com.sourcepad.sourcepadsuite.presentation.BaseRecyclerAdapter
import com.sourcepad.sourcepadsuite.presentation.model.CommendationUiModel
import kotlinx.android.synthetic.main.item_shoutout.view.*

class CommendationAdapter : BaseRecyclerAdapter<CommendationUiModel>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BaseViewHolder {
        return BaseRecyclerAdapter.BaseViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_shoutout,
                p0, false))
    }

    override fun onBindViewHolder(p0: BaseViewHolder, p1: Int) {
        val item = getItem(p1)
        p0.itemView.apply {
            fromTv.text = " from ${item.from}"
            toTv.text = "${item.to}"
            valueTv.text = item.text
            dateTv.text = item.date
            typeTv.text = item.type
        }
    }
}