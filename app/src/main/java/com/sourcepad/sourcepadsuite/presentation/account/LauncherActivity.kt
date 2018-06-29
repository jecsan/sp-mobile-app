package com.sourcepad.sourcepadsuite.presentation.account

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.greyblocks.gatekeeper.GateKeeper
import com.sourcepad.sourcepadsuite.R
import com.sourcepad.sourcepadsuite.presentation.MainActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class LauncherActivity : AppCompatActivity() {

    @Inject
    lateinit var gateKeeper: GateKeeper

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        if (gateKeeper.isLoggedIn()) {
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
            return
        }

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, LoginFragment())
                .commit()
    }
}