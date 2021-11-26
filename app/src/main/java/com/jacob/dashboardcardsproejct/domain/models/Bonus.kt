package com.jacob.dashboardcardsproejct.domain.models


data class Bonus(
    val totalRUB: Double,
    val totalUSD: Double,
    val team: Int,
    val refillUSD: Double,
    val refillRUB: Int,
    val about: String,
)