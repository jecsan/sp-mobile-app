package com.sourcepad.sourcepadsuite.data.api

import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SpApi {

    @POST("sso/mock_mobile_login")
    @FormUrlEncoded
    fun login(@Field("email") email: String) : Observable<UserResponse>
}