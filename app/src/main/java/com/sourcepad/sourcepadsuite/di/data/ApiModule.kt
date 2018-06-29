package com.sourcepad.sourcepadsuite.di.data

import com.sourcepad.sourcepadsuite.data.api.SpApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideSpApi(retrofit: Retrofit): SpApi {
        return retrofit.create(SpApi::class.java)
    }


    interface Exposes {

        val provideSpApi: SpApi

    }

}