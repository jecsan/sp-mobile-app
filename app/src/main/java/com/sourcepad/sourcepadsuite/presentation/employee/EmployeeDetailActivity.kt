package com.sourcepad.sourcepadsuite.presentation.employee

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sourcepad.sourcepadsuite.R

class EmployeeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_container)

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, EmployeeDetailFragment())
                .commit()
    }
}