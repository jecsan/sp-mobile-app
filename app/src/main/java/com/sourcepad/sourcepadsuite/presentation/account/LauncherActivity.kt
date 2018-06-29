package com.sourcepad.sourcepadsuite.presentation.account

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sourcepad.sourcepadsuite.R

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, LoginFragment())
                .commit()
    }
}