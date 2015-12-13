package com.eyewyre

import android.content.Intent
import android.content.res.Configuration
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.ActionBarActivity
import android.os.Bundle
import android.util.Log
import android.app.Activity
import android.view.{Menu, MenuItem, View}
import android.widget.ListView


class MainActivity extends ActionBarActivity {
  var drawerLayout: DrawerLayout = null
  var drawerView: ListView = null
  var drawerToggle: ActionBarDrawerToggle = null


  override def onCreate(savedInstanceState: Bundle): Unit = {
    setTheme(R.style.AppTheme)
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main)

    drawerLayout = findViewById(R.id.drawer_layout).asInstanceOf[DrawerLayout]

    getSupportActionBar.setDisplayHomeAsUpEnabled(true)
    getSupportActionBar.setHomeButtonEnabled(true)

    drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START)

    drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close) {
      override def onDrawerClosed(view: View) {
        getSupportActionBar.setTitle("Scala App Template")
        invalidateOptionsMenu()
      }

      override def onDrawerOpened(drawer: View) {
        getSupportActionBar.setTitle("Settings")
        invalidateOptionsMenu()
      }
    }

    drawerLayout.setDrawerListener(drawerToggle)
	}

  override def onCreateOptionsMenu(menu: Menu): Boolean = {
    getMenuInflater.inflate(R.menu.menu_main, menu)
    true
  }

  override def onOptionsItemSelected(item: MenuItem): Boolean = {
    val id = item.getItemId

    if(drawerToggle.onOptionsItemSelected(item)) true
    else if(id == R.id.action_settings) {
      // show settings activity
      true
    }

    else super.onOptionsItemSelected(item)
  }

  override def onPostCreate(savedInstanceState: Bundle) {
    super.onPostCreate(savedInstanceState)
    drawerToggle.syncState()
  }

  override def onConfigurationChanged(newConfig: Configuration) {
    super.onConfigurationChanged(newConfig)
    drawerToggle.onConfigurationChanged(newConfig)
  }

}