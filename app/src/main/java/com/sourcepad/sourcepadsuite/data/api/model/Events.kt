package com.sourcepad.sourcepadsuite.data.api.model

import com.google.gson.annotations.SerializedName

class Events(@SerializedName("data") val events: List<Event>) {
}