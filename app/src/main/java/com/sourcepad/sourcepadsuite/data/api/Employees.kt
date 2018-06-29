package com.sourcepad.sourcepadsuite.data.api

import com.google.gson.annotations.SerializedName

class Employees(@SerializedName("data") val users: List<User>   ) {
}