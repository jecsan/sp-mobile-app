package com.sourcepad.sourcepadsuite.data.api.model

import com.google.gson.annotations.SerializedName

class Commendation(@SerializedName("id") val id: String, @SerializedName("type") val type: String,
                   @SerializedName("attributes") val attributes: Attr) {

    class Attr(@SerializedName("message") val message: String,
               @SerializedName("to_employee") val to: String,
               @SerializedName("from_employee") val from: String,
               @SerializedName("is_cit") val isCit: Boolean)
}