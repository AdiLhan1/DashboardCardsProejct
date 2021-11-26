package com.jacob.dashboardcardsproejct.domain.repositories

import com.jacob.dashboardcardsproejct.common.resource.Resource
import com.jacob.dashboardcardsproejct.data.network.entities.DashboardResponse
import com.jacob.dashboardcardsproejct.domain.models.Bonus
import com.jacob.dashboardcardsproejct.domain.models.Grade
import com.jacob.dashboardcardsproejct.domain.models.Profit
import com.jacob.dashboardcardsproejct.domain.models.Refill
import kotlinx.coroutines.flow.Flow

interface DashboardRepository {
    fun fetchGrade(token: String): Flow<Resource<DashboardResponse>>
    fun fetchRefill(token: String): Flow<Resource<DashboardResponse>>
    fun fetchProfit(token: String): Flow<Resource<DashboardResponse>>
    fun fetchBonus(token: String): Flow<Resource<DashboardResponse>>
}