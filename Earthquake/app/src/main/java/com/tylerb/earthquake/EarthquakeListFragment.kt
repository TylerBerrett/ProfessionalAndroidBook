package com.tylerb.earthquake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EarthquakeListFragment(): Fragment() {

    private val mEarthquakes = ArrayList<Earthquake>()
    private lateinit var mRecyclerView: RecyclerView
    private val mEarthquakeAdapter = EarthquakeRecyclerViewAdapter(mEarthquakes)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_earthquake_list, container, false)
        mRecyclerView = view.findViewById(R.id.list)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context = view.context
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mRecyclerView.adapter = mEarthquakeAdapter
    }

    fun setEarthquakes(earthquakes: List<Earthquake>) {
        earthquakes.forEach {
            if (!mEarthquakes.contains(it)) {
                mEarthquakes.add(it)
                mEarthquakeAdapter.notifyItemInserted(mEarthquakes.indexOf(it))
            }
        }
    }
}