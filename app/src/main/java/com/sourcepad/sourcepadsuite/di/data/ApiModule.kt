package com.sourcepad.sourcepadsuite.di.data

import com.sourcepad.suite.data.Api
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideSpApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }


    interface Exposes {

        val provideApi: Api

    }

}