package com.tylerb.earthquake

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_earthquake.view.*

class EarthquakeRecyclerViewAdapter(private val earthquakes: List<Earthquake>):
    RecyclerView.Adapter<EarthquakeRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_earthquake, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = earthquakes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.earthquake = earthquakes[position]
        holder.detailsView.text = earthquakes[position].toString()
    }

    class ViewHolder(private val view: View): RecyclerView.ViewHolder(view)  {
        val parentView = view
        val detailsView = view.list_item_earthquake_details
        lateinit var earthquake: Earthquake

        override fun toString(): String {
            return "${super.toString()} '${detailsView.text}'"
        }
    }

}