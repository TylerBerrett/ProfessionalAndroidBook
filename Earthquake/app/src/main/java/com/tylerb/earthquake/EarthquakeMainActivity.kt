package com.tylerb.earthquake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.collections.ArrayList

class EarthquakeMainActivity : AppCompatActivity() {

    private val TAG_LIST_FRAGMENT = "TAG_LIST_FRAGMENT"

    lateinit var mEarthquakeListFragment: EarthquakeListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_earthquake_main)

        val fm = supportFragmentManager
        if (savedInstanceState == null) {
            val ft = fm.beginTransaction()
            mEarthquakeListFragment = EarthquakeListFragment()
            ft.add(R.id.main_activity_frame, mEarthquakeListFragment, TAG_LIST_FRAGMENT)
            ft.commitNow()
        } else {
            mEarthquakeListFragment = fm.findFragmentByTag(TAG_LIST_FRAGMENT) as EarthquakeListFragment
        }

        val now = Calendar.getInstance().time
        val dummyQuakes = ArrayList<Earthquake>(0)
        dummyQuakes.add(Earthquake("0", now, "San Jose", null, 7.3, null))
        dummyQuakes.add(Earthquake("1", now, "LA", null, 6.5, null))

        mEarthquakeListFragment.setEarthquakes(dummyQuakes)


    }
}
