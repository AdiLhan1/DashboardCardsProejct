package com.jacob.dashboardcardsproejct.domain.usecases

import com.jacob.dashboardcardsproejct.domain.repositories.DashboardRepository
import javax.inject.Inject

class FetchProfitUseCase @Inject constructor(
    private val repository: DashboardRepository
) {
    operator fun invoke(token: String) = repository.fetchProfit(token)
}