package com.example.hslar.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.hslar.Model.FuzzyTripModel
import com.example.hslar.R
import java.text.SimpleDateFormat
import java.util.*


class NextStopsAdapter (var mCtx: Context, var resource: Int, var items: List<FuzzyTripModel>) :
    ArrayAdapter<FuzzyTripModel>(mCtx, resource, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(resource, null)

        val busStopName: TextView = view.findViewById(R.id.busStopName)
        val stopTime: TextView = view.findViewById(R.id.stopTime)
        val busCurrent: ImageView = view.findViewById(R.id.busCurrent)
        val routeLine: ImageView = view.findViewById(R.id.routeLine)


        if(items[position].firstOrLast == 1){
            routeLine.setImageResource(R.drawable.bottom)
        }
        if(items[position].firstOrLast == 2){
            routeLine.setImageResource(R.drawable.up)
        }
        if(items[position].active == true){
            busCurrent.visibility = View.VISIBLE
        }
        val mFuzzyTrip = items[position]


        stopTime.text = "${turnToDate(mFuzzyTrip.schedulerArrival - 7200)}"

        busStopName.text = mFuzzyTrip.stopModelSimple.name
        return view

    }
    @SuppressLint("SimpleDateFormat")
    fun turnToDate(epoch: Int): String{
        return java.text.SimpleDateFormat("HH:mm:ss").format(Date(epoch.toLong() * 1000))
    }

}