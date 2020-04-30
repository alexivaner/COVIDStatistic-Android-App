package com.example.covidstat

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class ProfileActivity: AppCompatActivity(),View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)

        val btnToInstagram: Button = findViewById(R.id.btnFollow)
        btnToInstagram.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnFollow -> {
                val url = ("https://www.instagram.com/ivan.hutomo/")
                val openIg = Intent(Intent.ACTION_VIEW, Uri.parse(url))

                openIg.setPackage("com.instagram.android")
                startActivity(openIg)


            }
        }
    }
}