package com.jacob.dashboardcardsproejct.data.repositories

import com.jacob.dashboardcardsproejct.base.BaseRepository
import com.jacob.dashboardcardsproejct.data.network.apiservices.DashboardApiService
import com.jacob.dashboardcardsproejct.domain.repositories.DashboardRepository
import javax.inject.Inject

class DashboardRepositoryImpl @Inject constructor(
    private val service: DashboardApiService
) : BaseRepository(), DashboardRepository {

    override fun fetchGrade(token: String) = doRequest {
        service.fetchGrade(token)
    }

    override fun fetchRefill(token: String) = doRequest {
        service.fetchRefill(token)
    }

    override fun fetchProfit(token: String) = doRequest {
        service.fetchProfit(token)
    }

    override fun fetchBonus(token: String) = doRequest {
        service.fetchBonus(token)
    }

}