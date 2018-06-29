package com.sourcepad.sourcepadsuite.data.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import java.util.*

@Entity
data class ShoutOut(@Id var id:Long, val type: String, val from: String, val to: String,
                    val text: String, val date: Date) {

}