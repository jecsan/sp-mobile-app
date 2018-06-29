package com.sourcepad.sourcepadsuite.di

import android.accounts.AccountManager
import android.content.Context
import android.content.SharedPreferences
import android.os.Handler
import android.os.Looper
import android.preference.PreferenceManager
import com.greyblocks.gatekeeper.GateKeeper
import com.sourcepad.sourcepadsuite.R
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton


const val SCHEDULER_MAIN_THREAD = "mainThread"
const val SCHEDULER_IO = "io"
const val ACCOUNT_TYPE = "account_type"

@Module(includes = [(AndroidInjectionModule::class)])
class AppModule(val context: Context) {


    @Provides
    @Named(SCHEDULER_MAIN_THREAD)
    fun provideAndroidMainThreadScheduler(): Scheduler = AndroidSchedulers.mainThread()

    @Provides
    @Named(SCHEDULER_IO)
    fun provideIoScheduler(): Scheduler = Schedulers.io()

    @Provides
    fun provideSharedPreferences(): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @Provides
    fun provideAccountManager(): AccountManager {
        return AccountManager.get(context)
    }

    @Provides
    @Named(ACCOUNT_TYPE)
    fun provideAccountType(): String {
        return context.getString(R.string.account_type)
    }

    @Provides
    @Singleton
    fun provideGateKeeper(accountManager: AccountManager,
                          @Named(ACCOUNT_TYPE) accountType: String,
                          sharedPreferences: SharedPreferences): GateKeeper {
        return GateKeeper(accountManager, sharedPreferences, accountType, Handler(Looper.getMainLooper()))
    }


}