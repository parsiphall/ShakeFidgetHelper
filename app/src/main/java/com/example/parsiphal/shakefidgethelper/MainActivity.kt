package com.example.parsiphal.shakefidgethelper

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.parsiphal.shakefidgethelper.fragment.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        fragmentPlace(StartFragment())
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_unlocks -> fragmentPlace(UnlockFragment())
            R.id.nav_quest -> fragmentPlace(QuestFragment())
            R.id.nav_weapon -> fragmentPlace(WeaponFragment())
            R.id.nav_dungeon -> fragmentPlace(DungeonFragment())
            R.id.nav_citadel -> fragmentPlace(CitadelFragment())
            R.id.nav_mirror -> fragmentPlace(MirrorFragment())
            R.id.nav_pets -> fragmentPlace(PetsFragment())
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun fragmentPlace(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .replace(R.id.content_main, fragment)
            .commit()
    }
}
