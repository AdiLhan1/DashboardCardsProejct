package com.jacob.dashboardcardsproejct.data.network.apiservices

import com.jacob.dashboardcardsproejct.data.network.entities.DashboardResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface DashboardApiService {

    @GET("dashboards/grade")
    suspend fun fetchGrade(@Header("Authorization") token: String): DashboardResponse

    @GET("dashboards/refill")
    suspend fun fetchRefill(@Header("Authorization") token: String): DashboardResponse

    @GET("dashboards/profit")
    suspend fun fetchProfit(@Header("Authorization") token: String): DashboardResponse

    @GET("dashboards/bonus")
    suspend fun fetchBonus(@Header("Authorization") token: String): DashboardResponse
}