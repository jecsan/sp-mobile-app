package com.sourcepad.sourcepadsuite.presentation.shoutout

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sourcepad.sourcepadsuite.R
import com.sourcepad.sourcepadsuite.presentation.model.ShoutOutUiModel
import kotlinx.android.synthetic.main.fragment_list.*

class ShoutFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = ShoutAdapter().apply {
            this.items = ArrayList<ShoutOutUiModel>().apply {
                for (i in 0..20) {
                    add(ShoutOutUiModel(1, "Shout-out", "girltester",
                            "boytester", " Helping out golfcrow", "06-30-2018"))

                }
            }
        }
    }
}