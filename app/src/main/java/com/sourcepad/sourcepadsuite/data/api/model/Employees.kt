package com.sourcepad.sourcepadsuite.data.api.model

import com.google.gson.annotations.SerializedName

class Employees(@SerializedName("data") val users: List<User>) {
}