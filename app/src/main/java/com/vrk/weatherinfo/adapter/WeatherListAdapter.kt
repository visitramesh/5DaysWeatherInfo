package com.vrk.weatherinfo.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vrk.weatherinfo.R
import com.vrk.weatherinfo.data.WeatherList


open class WeatherListAdapter(private val mList: List<WeatherList>) : RecyclerView.Adapter<WeatherListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_parent, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]
        holder.dateAndTime.text = ItemsViewModel.dt_txt
        val forecastListAdapter = ForecastListAdapter(ItemsViewModel.main)
        holder.recyclerView.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL,false)
        holder.recyclerView.adapter = forecastListAdapter
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val dateAndTime: TextView = itemView.findViewById(R.id.dateandTime)
        val windTextView: TextView = itemView.findViewById(R.id.wind)
        val rainTextView: TextView = itemView.findViewById(R.id.rain)
        val cloudTextView: TextView = itemView.findViewById(R.id.clouds)
        val recyclerView: RecyclerView = itemView.findViewById(R.id.childRecyclerView)
    }
}