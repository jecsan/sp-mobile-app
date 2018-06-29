package com.sourcepad.sourcepadsuite.presentation.model

import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel
data class EmployeeUiModel @ParcelConstructor constructor(val id: String, val name: String,
                                                          val title: String, val phoneNumber: String,
                                                          val avatarSlug: String, val skype: String,
                                                          val tin: String, val sss: String,
                                                          val startDate: String, val idNumber: String, val location: String,
val emergencyContactName:String, val emergencyContactNum: String, val email:String, val bDate:String) {
}