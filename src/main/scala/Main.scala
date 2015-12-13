package com.eyewyre

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Menu
import android.view.MenuItem
import android.view.View.OnClickListener


class MainActivity extends Activity {
	override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main)

    val v = List(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
    Log.wtf("app", v.map(c => (c * 100)).mkString(","))

		Log.wtf("app", "************ Test")
	}
}