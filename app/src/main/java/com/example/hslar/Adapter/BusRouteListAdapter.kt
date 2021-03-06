package com.example.hslar.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.hslar.Model.RouteModel
import com.example.hslar.R

class BusRouteListAdapter (var mCtx: Context, var resource: Int, var items: List<RouteModel>)
    :ArrayAdapter<RouteModel>(mCtx, resource, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view:View = layoutInflater.inflate(resource, null)

        val mBusLineNum: TextView = view.findViewById(R.id.busline)
        val mVehImg: ImageView = view.findViewById(R.id.vehView)

        var mItems: RouteModel = items[position]


        if(mItems.mode == "BUS"){
            mVehImg.setImageResource(R.drawable.ic_directions_bus_black_24dp)
        } else if(mItems.mode == "SUBWAY"){
            mVehImg.setImageResource(R.drawable.ic_directions_subway_black_24dp)
        } else if(mItems.mode == "RAIL"){
            mVehImg.setImageResource(R.drawable.ic_train_black_24dp)
        }
        mBusLineNum.text = mItems.shortName


        return view
    }
}