package com.sourcepad.sourcepadsuite.presentation.employee

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sourcepad.sourcepadsuite.R
import com.sourcepad.sourcepadsuite.presentation.account.Key
import com.sourcepad.sourcepadsuite.presentation.model.EmployeeUiModel
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_employee_detail.*
import org.parceler.Parcels


class EmployeeDetailFragment : Fragment() {

    companion object {
        fun newInstance(args: Bundle): EmployeeDetailFragment {
            return EmployeeDetailFragment().apply {
                arguments = args
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_employee_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val employeeUiModel = Parcels.unwrap<EmployeeUiModel>(arguments?.getParcelable(Key.PARCEL))
        nameTv.text = employeeUiModel.name
        titleTv.text = employeeUiModel.title
        personToNotifyNumberTv.text = employeeUiModel.emergencyContactNum
        personToNotifyTv.text = employeeUiModel.emergencyContactName

        phoneNumTv.text = employeeUiModel.phoneNumber
        emailTv.text = employeeUiModel.email
        locationTv.text = employeeUiModel.location
        birthDateTv.text = employeeUiModel.bDate
        tinTv.text = employeeUiModel.tin
        sssTv.text = employeeUiModel.sss
        idTv.text = employeeUiModel.idNumber

        emailIb.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse("mailto:${emailTv.text}")
            startActivity(emailIntent)
        }

        callIb.setOnClickListener {
            getCallPermission().subscribe {
                if (it) call(phoneNumTv.text.toString())
            }
        }

        sms.setOnClickListener {
            sendSms(phoneNumTv.text.toString())
        }

        emergencyCallIb.setOnClickListener {
            getCallPermission().subscribe {
                if (it) call(personToNotifyNumberTv.text.toString())
            }
        }


        emergencySms.setOnClickListener {
            sendSms(personToNotifyNumberTv.text.toString())
        }

    }

    private fun sendSms(phoneNumber: String){
        val uri = Uri.parse("smsto:$phoneNumber")
        val it = Intent(Intent.ACTION_SENDTO, uri)
        startActivity(it)
    }

    private fun getCallPermission(): Observable<Boolean> {
        return RxPermissions(activity as Activity).request(Manifest.permission.CALL_PHONE)
    }

    private fun call(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$phoneNumber"))
        startActivity(intent)
    }
}