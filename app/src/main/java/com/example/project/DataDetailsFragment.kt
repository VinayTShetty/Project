package com.example.project

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

class DataDetailsFragment : Fragment() {

    private val args by navArgs<DataDetailsFragmentArgs>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("Data", "onCreateView: ${args.countriesData.capital}")

        return inflater.inflate(R.layout.fragment_data_details, container, false)
    }
}