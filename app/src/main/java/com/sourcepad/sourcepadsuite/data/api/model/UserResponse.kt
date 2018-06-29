package com.sourcepad.sourcepadsuite.data.api.model

import com.google.gson.annotations.SerializedName

class UserResponse(@SerializedName("data") val user: User) {
}