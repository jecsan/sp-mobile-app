package com.sourcepad.sourcepadsuite.presentation

import android.support.v7.widget.RecyclerView
import android.view.View
import io.reactivex.subjects.PublishSubject

abstract class BaseRecyclerAdapter<T>() : RecyclerView.Adapter<BaseRecyclerAdapter.BaseViewHolder>() {

    var items: List<T> = emptyList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    val onClickSubject: PublishSubject<T> = PublishSubject.create<T>()

    constructor(items: List<T>) : this() {
        this.items = items
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun getItem(pos: Int) :T {
        return items[pos]
    }

    class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}