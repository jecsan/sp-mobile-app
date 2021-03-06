package com.sourcepad.sourcepadsuite.di

import com.sourcepad.sourcepadsuite.presentation.MainActivity
import com.sourcepad.sourcepadsuite.presentation.account.LauncherActivity
import com.sourcepad.sourcepadsuite.presentation.account.LoginFragment
import com.sourcepad.sourcepadsuite.presentation.commendation.CommendationFragment
import com.sourcepad.sourcepadsuite.presentation.dashboard.DashboardFragment
import com.sourcepad.sourcepadsuite.presentation.employee.EmployeeFragment
import com.sourcepad.suite.presentation.DetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Add the activities/fragments to be injected here
 */
@Module
abstract class BuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeLauncherActivty(): LauncherActivity

    @ContributesAndroidInjector
    abstract fun contributeDetailFragment(): DetailFragment

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    abstract fun contributeDashboardFragment(): DashboardFragment

    @ContributesAndroidInjector
    abstract fun contributeEmployeeFragment(): EmployeeFragment

    @ContributesAndroidInjector
    abstract fun contributeCommendationFragment(): CommendationFragment
}