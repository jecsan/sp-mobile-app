package com.sourcepad.sourcepadsuite.presentation.dashboard

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.util.SparseArray
import com.sourcepad.sourcepadsuite.presentation.TabFragment

class DashboardPagerAdater(private val fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {


    private val fragments = SparseArray<Fragment>().apply {
        this.put(0, TabFragment())
        this.put(1, TabFragment())
        this.put(2, TabFragment())
        this.put(3, TabFragment())
        this.put(4, TabFragment())
    }


    override fun getCount(): Int = fragments.size()


    override fun getItem(p0: Int): Fragment = fragments[p0]


}