package com.sourcepad.suite.presentation

import android.os.Bundle
import android.support.v4.app.Fragment
import com.sourcepad.suite.di.viewmodels.ViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DetailFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var detailFragmentViewModel: DetailFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        detailFragmentViewModel = viewModelFactory.create(DetailFragmentViewModel::class.java)
    }


}