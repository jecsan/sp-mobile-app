package com.sourcepad.sourcepadsuite.data.api

import io.reactivex.Observable
import retrofit2.http.*

interface SpApi {

    @POST("sso/mock_mobile_login")
    @FormUrlEncoded
    fun login(@Field("email") email: String) : Observable<UserResponse>

    @GET("users")
    fun getEmployees() : Observable<List<User>>

    @GET("users/{id}")
    fun getEmployee(@Path("id") id: String) : Observable<List<User>>
}