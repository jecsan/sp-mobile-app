package com.sourcepad.sourcepadsuite.data.api

import com.google.gson.annotations.SerializedName

class UserResponse(@SerializedName("data") val user: User) {
}