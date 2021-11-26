package com.jacob.dashboardcardsproejct.data.network.entities

import com.google.gson.annotations.SerializedName

class DashboardResponse(
    @SerializedName("total")
    val total: Double,
    @SerializedName("balanceUSD")
    val balanceUSD: Double,
    @SerializedName("raise")
    val raise: Double,
    @SerializedName("about")
    val about: String,
    @SerializedName("stock")
    val stock: Double?,
    @SerializedName("balanceRUB")
    val balanceRUB: Int,
    @SerializedName("withdrawn")
    val withdrawn: Double,
    @SerializedName("refillUSD")
    val refillUSD: Double,
    @SerializedName("refillRUB")
    val refillRUB: Int,
    @SerializedName("price")
    val price: Double,
    @SerializedName("invest")
    val invest: Double?,
    @SerializedName("totalRUB")
    val totalRUB: Double,
    @SerializedName("team")
    val team: Int?,
    @SerializedName("totalUSD")
    val totalUSD: Double,
)