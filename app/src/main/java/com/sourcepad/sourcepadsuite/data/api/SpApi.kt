package com.sourcepad.sourcepadsuite.data.api

import com.sourcepad.sourcepadsuite.data.api.model.Commendations
import com.sourcepad.sourcepadsuite.data.api.model.Employees
import com.sourcepad.sourcepadsuite.data.api.model.Events
import com.sourcepad.sourcepadsuite.data.api.model.UserResponse
import io.reactivex.Observable
import retrofit2.http.*

interface SpApi {

    @POST("sso/mock_mobile_login")
    @FormUrlEncoded
    fun login(@Field("email") email: String): Observable<UserResponse>

    @GET("users")
    fun getEmployees(): Observable<Employees>

    @GET("commendations")
    fun getCommendations(): Observable<Commendations>

    @GET("users/{id}")
    fun getEmployee(@Path("id") id: String): Observable<Employees>

    @GET("company_events")
    fun getCompanyEvents() : Observable<Events>
}