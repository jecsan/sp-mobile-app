package com.sourcepad.sourcepadsuite.data.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("id")
    @Expose
    lateinit var id: String
    @SerializedName("attributes")
    lateinit var attributes: Attributes
}