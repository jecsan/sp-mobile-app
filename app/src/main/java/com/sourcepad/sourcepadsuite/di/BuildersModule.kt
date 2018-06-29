package com.sourcepad.sourcepadsuite.di
import com.sourcepad.sourcepadsuite.presentation.MainActivity
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
    abstract fun contributeDetailFragment(): DetailFragment

}