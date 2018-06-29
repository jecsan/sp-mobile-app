package com.sourcepad.sourcepadsuite

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import com.greyblocks.gatekeeper.Gate
import com.sourcepad.sourcepadsuite.di.AppModule
import com.sourcepad.sourcepadsuite.di.DaggerAppComponent
import com.sourcepad.sourcepadsuite.di.data.ApiModule
import com.sourcepad.sourcepadsuite.di.data.NetworkModule
import com.sourcepad.sourcepadsuite.presentation.account.LauncherActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class SpSuiteApplication : Application(), HasActivityInjector, HasSupportFragmentInjector, Gate {

    override fun getGateClass(): Class<*> {
        return LauncherActivity::class.java
    }

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector


    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
                .apiModule(ApiModule())
                .appModule(AppModule(applicationContext))
                .networkModule(NetworkModule(this))
                .build().inject(this)
    }
}