package com.sourcepad.sourcepadsuite.di

import com.sourcepad.sourcepadsuite.di.data.ApiModule
import com.sourcepad.sourcepadsuite.di.data.NetworkModule
import com.sourcepad.sourcepadsuite.SpSuiteApplication
import com.sourcepad.suite.di.viewmodels.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by jsantiago on 3/5/18.
 */
@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ApiModule::class,
    NetworkModule::class,
    AppModule::class,
    ViewModelModule::class,
    BuildersModule::class
])

interface AppComponent {

    fun inject(spSuiteApplication: SpSuiteApplication)

}
