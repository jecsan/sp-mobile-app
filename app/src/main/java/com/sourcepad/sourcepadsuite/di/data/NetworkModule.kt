package com.sourcepad.sourcepadsuite.di.data

import android.content.Context
import com.sourcepad.sourcepadsuite.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [(AndroidInjectionModule::class)])
class NetworkModule(val context: Context) {

    /**
     * For intercepting requests, tokens can be added here
     */
    @Provides
    @Singleton
    fun provideTokenInterceptor(): Interceptor {
        return Interceptor {
            it.proceed(it.request())
        }
    }

//    @Provides
//    @Singleton
//    fun provideAuthenticator() : Authenticator{
//        return Authenticator { route, response ->  ro}
//    }

    @Provides
    @Singleton
    fun provideOkHttpClient(tokenInterceptor: Interceptor): OkHttpClient {
        val okBuilder = OkHttpClient.Builder()
        okBuilder
                .addInterceptor(tokenInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
        okBuilder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        return okBuilder.build()
    }



    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().client(okHttpClient)
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }


}