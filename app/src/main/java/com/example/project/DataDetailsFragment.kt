package com.example.project

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.data.Countries

class DataDetailsFragment : Fragment() {
    private lateinit var countryFlag: ImageView
    private lateinit var countryDetails: TextView
    private val args by navArgs<DataDetailsFragmentArgs>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("Data", "onCreateView: ${args.countriesData.capital}")
        val view=inflater.inflate(R.layout.fragment_data_details, container, false)
        val countryObject=args.countriesData
        intializeWidgets(view,countryObject)
        return view
    }

    fun intializeWidgets(view: View, countries: Countries){
        val countryinfo=
            "\n"+"Name "+args.countriesData.name
        "\n"+"Capital "+args.countriesData.capital
        "\n"+"Region "+args.countriesData.region
        countryFlag=view.findViewById(R.id.countryFlag)
        countryDetails=view.findViewById(R.id.countryDetails)
        countryDetails.setText(countryinfo.toString())
        context?.let {
            Glide.with(it)
                .load(countries.flags?.png)
                .into(countryFlag)
        }
    }
}