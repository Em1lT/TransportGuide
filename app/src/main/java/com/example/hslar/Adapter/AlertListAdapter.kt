package com.example.hslar.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.hslar.Model.AlertModel
import com.example.hslar.R

class AlertListAdapter(var mCtx: Context, var resource: Int, var items: List<AlertModel>) :
    ArrayAdapter<AlertModel>(mCtx, resource, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(resource, null)

        val alertText: TextView = view.findViewById(R.id.alertDescription)
        val alertStartDate: TextView = view.findViewById(R.id.startDate)
        val alertEndDate: TextView = view.findViewById(R.id.endDate)
        val stopAlert: TextView = view.findViewById(R.id.stopAlert)
        val speechBubble: LinearLayout = view.findViewById(R.id.speech_bubble)
        val vehicleImage: ImageView = view.findViewById(R.id.secondImage)
        val hslImage: ImageView = view.findViewById(R.id.hslLogo)

        var mAlert = items[position]
        if (mAlert.stop != null) {
            stopAlert.text = mAlert.stop!!.name
            val param = speechBubble.layoutParams as RelativeLayout.LayoutParams
            param.setMargins(70, 0, 40, 0)
            speechBubble.layoutParams = param

            //CREATE OWNT SPEECHBUBBLES FOR ALL
            when {
                mAlert.stop!!.vehicleMode == "BUS" -> {
                    hslImage.visibility = View.INVISIBLE
                    vehicleImage.setImageResource(R.drawable.busimage)
                    vehicleImage.visibility = View.VISIBLE
                    speechBubble.setBackgroundResource(R.drawable.speech_bubble_bus)
                }
                mAlert.stop!!.vehicleMode == "SUBWAY" -> {
                    hslImage.visibility = View.INVISIBLE
                    vehicleImage.setImageResource(R.drawable.metro)
                    vehicleImage.visibility = View.VISIBLE
                    speechBubble.setBackgroundResource(R.drawable.speech_bubble_metro)
                }
                mAlert.stop!!.vehicleMode == "TRAM" -> {
                    hslImage.visibility = View.INVISIBLE
                    vehicleImage.setImageResource(R.drawable.tram)
                    vehicleImage.visibility = View.VISIBLE
                    speechBubble.setBackgroundResource(R.drawable.speech_bubble_metro)
                }
                mAlert.stop!!.vehicleMode == "TRAIN" -> {
                    hslImage.visibility = View.INVISIBLE
                    vehicleImage.setImageResource(R.drawable.train)
                    vehicleImage.visibility = View.VISIBLE
                    speechBubble.setBackgroundResource(R.drawable.speech_bubble_bus)
                }
            }
        }

        alertText.text = mAlert.alertDescriptionText
        alertStartDate.text = mAlert.effectiveStartDate
        alertEndDate.text = mAlert.effectiveEndDate

        return view
    }
}
