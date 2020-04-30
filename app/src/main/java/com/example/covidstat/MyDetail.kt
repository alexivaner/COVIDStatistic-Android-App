package com.example.covidstat

import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso


class MyDetail : AppCompatActivity() {
    private val mHandler: Handler = Handler()

    companion object {
        const val COUNTRY = "country"
        const val TODAYSUM = "capital"
        const val FLAGS = "flag"
        const val CONFIRMED = "1"
        const val DEATH = "2"
        const val RECOVERED = "3"
        const val DATE = "4"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail)


        val countryName: TextView = findViewById(R.id.country_profilename)
        val capitalName: TextView = findViewById(R.id.capital_profilename)
        val flagImage: ImageView = findViewById(R.id.flag_profilename)
        val total_: TextView = findViewById(R.id.total)
        val deaths_: TextView = findViewById(R.id.deaths)
        val recovered_:TextView = findViewById(R.id.recovered)
        val date_:TextView = findViewById(R.id.date)

        val country = intent.getStringExtra(COUNTRY)
        val capital = intent.getStringExtra(TODAYSUM)
        val flags = intent.getStringExtra(FLAGS)
        val total = intent.getStringExtra(CONFIRMED)
        val death = intent.getStringExtra(DEATH)
        val recovered = intent.getStringExtra(RECOVERED)
        val date=intent.getStringExtra(DATE)


        countryName.text=country
        capitalName.text=capital

        Picasso.get()
            .load(flags)
            .into(flagImage)

        total_.text= total
        deaths_.text= death
        recovered_.text= recovered
        date_.text="Terakhir diupdate pada:\n"+date


    }





}