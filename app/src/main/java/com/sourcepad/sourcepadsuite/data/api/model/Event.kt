package com.sourcepad.sourcepadsuite.data.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Event(@SerializedName("id") val id: String,
            @SerializedName("type") val type: String,
            @SerializedName("attributes") val attr: Attr) {

    class Attr {
        @SerializedName("id")
        @Expose
        var id: String? = null
        @SerializedName("date")
        @Expose
        var date: String? = null
        @SerializedName("event_type_id")
        @Expose
        var eventTypeId: String? = null
        @SerializedName("is_active")
        @Expose
        var isActive: Boolean? = null
        @SerializedName("is_annual")
        @Expose
        var isAnnual: Boolean? = null
        @SerializedName("name")
        @Expose
        var name: String? = null
        @SerializedName("created_at")
        @Expose
        var createdAt: String? = null
        @SerializedName("updated_at")
        @Expose
        var updatedAt: String? = null
    }


}