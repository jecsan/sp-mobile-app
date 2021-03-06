package com.sourcepad.sourcepadsuite.presentation

import android.app.LauncherActivity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.sourcepad.sourcepadsuite.R
import com.sourcepad.sourcepadsuite.presentation.dashboard.DashboardPagerAdater
import com.sourcepad.suite.di.viewmodels.ViewModelFactory
import com.sourcepad.suite.presentation.MainActivityViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var mainViewModel: MainActivityViewModel


    private val tabIcons = IntArray(5).apply {
        this[0] = R.drawable.ic_dashboard
        this[1] = R.drawable.ic_shoutout
        this[2] = R.drawable.ic_streams
        this[3] = R.drawable.ic_next24
        this[4] = R.drawable.ic_employees
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        mainViewModel = viewModelFactory.create(MainActivityViewModel::class.java)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()


        viewPager.adapter = DashboardPagerAdater(supportFragmentManager)
        tabs.setupWithViewPager(viewPager)

        for (i in 0..tabs.tabCount) {
            tabs.getTabAt(i)?.setIcon(tabIcons[i])
        }



        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onResume() {
        super.onResume()
        Handler(Looper.getMainLooper()).postDelayed({
            mainViewModel.checkAuth(this)
        }, 5000)

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {

            R.id.nav_logout -> {
                mainViewModel.logout()
                mainViewModel.checkAuth(this)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
