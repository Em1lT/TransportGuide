package com.example.hslar.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.hslar.Model.StopModel
import com.example.hslar.R
import kotlin.math.roundToInt

class StopListAdapter(var mCtx: Context, var resource: Int, var items: List<StopModel>)
    : ArrayAdapter<StopModel>(mCtx, resource, items){

    @SuppressLint("SetTextI18n", "ResourceType")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(resource, null)

        val stopId: TextView = view.findViewById(R.id.stopId)
        val desc: TextView = view.findViewById(R.id.stopDesc)
        val zoneId: TextView = view.findViewById(R.id.zoneId)
        val dist: TextView = view.findViewById(R.id.distanceFromMe)

        var mItems: StopModel = items[position]


        stopId.text = mItems.code
        desc.text = mItems.name
        zoneId.text = mItems.zoneId
        if(mItems.dist.toDouble() > 1000){
            dist.text = "${"%.2f".format(mItems.dist.toDouble() / 1000)} ${context.getString(R.string.kmaway)}"
        } else {
            dist.text = "${(mItems.dist.toDouble()).roundToInt()} ${context.getString(R.string.maway)}"
        }
        return view
    }

}