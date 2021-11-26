package com.jacob.dashboardcardsproejct.domain.models

data class Refill(
    val total: Double,
    val withdrawn: Double,
    val refillUSD: Double,
    val refillRUB: Int,
    val about: String,
)