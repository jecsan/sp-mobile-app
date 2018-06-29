package com.sourcepad.sourcepadsuite.data.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("display_name")
    @Expose
    var displayName: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("department")
    @Expose
    var department: String? = null
    @SerializedName("position")
    @Expose
    var position: String? = null
    @SerializedName("mobile_number")
    @Expose
    var mobileNumber: Any? = null
    @SerializedName("skype")
    @Expose
    var skype: String? = null
    @SerializedName("office_location")
    @Expose
    var officeLocation: String? = null
    @SerializedName("start_date")
    @Expose
    var startDate: String? = null
    @SerializedName("birthday")
    @Expose
    var birthday: String? = null
    @SerializedName("id_number")
    @Expose
    var idNumber: Int? = null
    @SerializedName("tin_number")
    @Expose
    var tinNumber: String? = null
    @SerializedName("sss_number")
    @Expose
    var sssNumber: String? = null
    @SerializedName("address")
    @Expose
    var address: String? = null
    @SerializedName("person_to_notify")
    @Expose
    var personToNotify: String? = null
    @SerializedName("person_to_notify_mobile")
    @Expose
    var personToNotifyMobile: String? = null
    @SerializedName("is_verified")
    @Expose
    var isVerified: Boolean? = null
    @SerializedName("access_token")
    @Expose
    var accessToken: String? = null
    @SerializedName("sso_token")
    @Expose
    var ssoToken: String? = null

}