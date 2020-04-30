package com.example.covidstat

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.covidstat.model2.Country
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.country_item.view.*


class MyAdapter(private val inihasil:MutableList<Country>) : RecyclerView.Adapter<MyHolder>() {


    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        context = parent.context
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.country_item, parent, false))

    }

    override fun getItemCount(): Int = inihasil.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val data2 = inihasil[position]

        val countryNameTextView = holder.itemView.country_name
        val slugNameTextView = holder.itemView.slug_name
        val countryCodeTextView = holder.itemView.country_code
        val flagImageView = holder.itemView.country_flag


        val countryName = "${data2.country}"
        countryNameTextView.text = countryName

        val newconfirmed = "${data2.newConfirmed}"
        val newrecovered = "${data2.newRecovered}"
        val newdeath = "${data2.newDeaths}"
        val text1="New Confirmed:"+newconfirmed+"\nNew Recovered:"+newrecovered+"\nNew Death:"+newdeath
        slugNameTextView.text = "New Confirmed:"+newconfirmed

        val countryCode = "${data2.countryCode}"
        countryCodeTextView.text = countryCode

        val confirmed = "${data2.totalConfirmed}"
        val death = "${data2.totalDeaths}"
        val recovered = "${data2.totalRecovered}"
        val date="${data2.date}"


        val flagurl = "https://www.countryflags.io/" + countryCode + "/flat/64.png"
        Picasso.get()
            .load(flagurl)
            .into(flagImageView)

        holder.itemView.setOnClickListener {

            val pindahDetail = Intent(context, MyDetail::class.java)
            Toast.makeText(context, countryName, Toast.LENGTH_SHORT).show()
            pindahDetail.putExtra(MyDetail.COUNTRY, countryName)
            pindahDetail.putExtra(MyDetail.TODAYSUM, text1)
            pindahDetail.putExtra(MyDetail.FLAGS, flagurl)
            pindahDetail.putExtra(MyDetail.CONFIRMED, confirmed.toString())
            pindahDetail.putExtra(MyDetail.DEATH, death.toString())
            pindahDetail.putExtra(MyDetail.RECOVERED, recovered.toString())
            pindahDetail.putExtra(MyDetail.DATE, date.toString())
            context.startActivity(pindahDetail)
        }

    }
}