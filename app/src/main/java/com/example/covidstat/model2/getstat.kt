package com.example.covidstat.model2


import com.google.gson.annotations.SerializedName

data class getstat(
    @SerializedName("Countries")
    val countries: List<Country>?,
    @SerializedName("Date")
    val date: String?,
    @SerializedName("Global")
    val global: Global?
)