package com.example.project

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ViewModel.CountryViewModel
import com.example.adapter.CountryAdapter
import com.example.data.Countries

/**
 * A simple [Fragment] subclass.
 * Use the [DataFragment.newInstance] factory method to
 * create an instance of this fragment.
 */


private lateinit var countryAdapter: CountryAdapter
private lateinit var recycleView_country: RecyclerView

class DataFragment : Fragment() ,CountryAdapter.CountryItemClickListner{
    private var countrylist: List<Countries>? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        intiateViewModel()
        return inflater.inflate(R.layout.fragment_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initateRecycleView(view)
    }



    private fun intiateViewModel() {
        val sharedViewModel = ViewModelProvider(requireActivity()).get(CountryViewModel::class.java)
        sharedViewModel.getLiveDataObserver().observe(viewLifecycleOwner, Observer {
                if(it!=null){
                    countryAdapter.setCountryList(it)
                    countrylist=it
                    countryAdapter.notifyDataSetChanged()
                }
        })
        sharedViewModel.makeAPICall()
    }

    private fun initateRecycleView(view: View) {
        recycleView_country = view.findViewById(R.id.recycleView_country)
        countryAdapter = CountryAdapter(this,this)
        recycleView_country.adapter= countryAdapter
        val my_layoutManager = LinearLayoutManager(context)
        recycleView_country.layoutManager=my_layoutManager
    }

    override fun myCountryItemClick(poisiotn: Int) {
      var countries =  countrylist?.get(poisiotn)
        Log.d("Mandira", "myCountryItemClick: ${countries?.capital.toString()}")
    }
}