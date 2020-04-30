package com.example.covidstat

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.example.covidstat.model2.Country
import com.example.covidstat.model2.getstat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val listhasil: MutableList<Country> = mutableListOf()
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val swipeRefresh: SwipeRefreshLayout = findViewById(R.id.swiperefresh)

        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = "Nama Negara"
        }

        fetch_adapter()
        swipeRefresh.setOnRefreshListener{
            fetch_adapter()
            swipeRefresh.isRefreshing = false
        }


    }

    private fun fetch_adapter() {
        myAdapter = MyAdapter(listhasil)
        //Intitialize recycler view
        main_layout.layoutManager = LinearLayoutManager(this)
        main_layout.addItemDecoration(DividerItemDecoration(this, OrientationHelper.VERTICAL))
        main_layout.adapter = myAdapter

        //Intialize network
        val urlcovid = "https://api.covid19api.com/summary"

        AndroidNetworking.initialize(this)
        AndroidNetworking.get(urlcovid)
            .build()
            .getAsObject(getstat::class.java, object : ParsedRequestListener<getstat> {
                override fun onResponse(response: getstat) {
                    listhasil.addAll(response.countries!!)
                    myAdapter.notifyDataSetChanged()

                }

                override fun onError(anError: ANError?) {
                }

            })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val pindahIntent = Intent(this@MainActivity, ProfileActivity::class.java)
        startActivity(pindahIntent)
        return super.onOptionsItemSelected(item)
    }


}



