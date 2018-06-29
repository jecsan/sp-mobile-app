package com.sourcepad.sourcepadsuite.presentation.employee

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.sourcepad.sourcepadsuite.R
import com.sourcepad.sourcepadsuite.presentation.account.Key
import com.sourcepad.sourcepadsuite.presentation.model.EmployeeUiModel
import kotlinx.android.synthetic.main.activity_fragment_container.*
import org.parceler.Parcels

class EmployeeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_container)
        val employeeUiModel = Parcels.unwrap<EmployeeUiModel>(intent.extras.getParcelable(Key.PARCEL))

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, EmployeeDetailFragment.newInstance(Bundle().also {
                    it.putParcelable(Key.PARCEL,Parcels.wrap(employeeUiModel))
                }))
                .commit()

        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            setHomeButtonEnabled(true)
            title = ""
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            android.R.id.home->{
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)

    }
}