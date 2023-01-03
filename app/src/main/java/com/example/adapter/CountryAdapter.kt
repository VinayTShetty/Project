package com.example.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.data.Countries
import com.example.project.DataFragment
import com.example.project.R

class CountryAdapter(
    val activity: DataFragment,
    val countryItemClickListner: CountryItemClickListner) :
    RecyclerView.Adapter<CountryAdapter.CountryItemView>() {

    private var countrylist: List<Countries>? = null

    fun setCountryList(loc_countrylist: List<Countries>) {
        this.countrylist = loc_countrylist
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryItemView {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.country_list_row, parent, false)
        return CountryItemView(view)
    }

    override fun onBindViewHolder(holder: CountryItemView, position: Int) {
        holder.bindData(countrylist!!.get(position), activity)
    }

    override fun getItemCount(): Int {
        if (countrylist == null) {
            return 0
        } else return countrylist!!.size
    }

   inner class CountryItemView(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val flagImage = itemView.findViewById<ImageView>(R.id.flagImage)
        val tvname = itemView.findViewById<TextView>(R.id.tvName)
        val tvCapital = itemView.findViewById<TextView>(R.id.tvCapital)
        val tvRegion = itemView.findViewById<TextView>(R.id.tvRegion)
        init {
                itemView.setOnClickListener(this)
        }
        fun bindData(countries: Countries, activity: DataFragment) {
            tvname.text = countries!!.name + " " + countries!!.alpha2Code
            tvCapital.text = "Capital " + countries.capital
            tvRegion.text = "Region " + countries.region
            Glide.with(activity)
                .load(countries.flags?.png)
                .into(flagImage)
        }

        override fun onClick(v: View?) {
            val position=adapterPosition
            countryItemClickListner.myCountryItemClick(position)
        }
    }

    interface CountryItemClickListner{
        fun myCountryItemClick(poisiotn:Int)
    }
}