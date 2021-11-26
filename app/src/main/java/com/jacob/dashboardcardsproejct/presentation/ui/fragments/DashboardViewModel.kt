package com.jacob.dashboardcardsproejct.presentation.ui.fragments

import androidx.lifecycle.viewModelScope
import com.jacob.dashboardcardsproejct.base.BaseViewModel
import com.jacob.dashboardcardsproejct.common.constants.Constants.ACCESS_TOKEN
import com.jacob.dashboardcardsproejct.data.network.entities.DashboardResponse
import com.jacob.dashboardcardsproejct.domain.usecases.FetchBonusUseCase
import com.jacob.dashboardcardsproejct.domain.usecases.FetchGradeUseCase
import com.jacob.dashboardcardsproejct.domain.usecases.FetchProfitUseCase
import com.jacob.dashboardcardsproejct.domain.usecases.FetchRefillUseCase
import com.jacob.dashboardcardsproejct.presentation.state.StatePresentation
import com.jacob.dashboardcardsproejct.presentation.state.StateViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val gradeUseCase: FetchGradeUseCase,
    private val refillUseCase: FetchRefillUseCase,
    private val profitUseCase: FetchProfitUseCase,
    private val bonusUseCase: FetchBonusUseCase
) : BaseViewModel() {

    private val _gradeState = StateViewModel<DashboardResponse>()
    val gradeState = StatePresentation<DashboardResponse>(
        _gradeState.isLoading,
        _gradeState.error,
        _gradeState.data
    )
    private val _refillState = StateViewModel<DashboardResponse>()
    val refillState = StatePresentation<DashboardResponse>(
        _refillState.isLoading,
        _refillState.error,
        _refillState.data
    )
    private val _profitState = StateViewModel<DashboardResponse>()
    val profitState = StatePresentation<DashboardResponse>(
        _profitState.isLoading,
        _profitState.error,
        _profitState.data
    )
    private val _bonusState = StateViewModel<DashboardResponse>()
    val bonusState = StatePresentation<DashboardResponse>(
        _bonusState.isLoading,
        _bonusState.error,
        _bonusState.data
    )

    init {
        fetchGrade("Bearer $ACCESS_TOKEN")
        fetchRefill("Bearer $ACCESS_TOKEN")
        fetchProfit("Bearer $ACCESS_TOKEN")
        fetchBonus("Bearer $ACCESS_TOKEN")
    }

    private fun fetchGrade(token: String) {
        viewModelScope.launch {
            subscribeTo(_gradeState) {
                gradeUseCase(token)
            }
        }
    }

    private fun fetchRefill(token: String) {
        viewModelScope.launch {
            subscribeTo(_refillState) {
                refillUseCase(token)
            }
        }
    }

    private fun fetchProfit(token: String) {
        viewModelScope.launch {
            subscribeTo(_profitState) {
                profitUseCase(token)
            }
        }
    }

    private fun fetchBonus(token: String) {
        viewModelScope.launch {
            subscribeTo(_bonusState) {
                bonusUseCase(token)
            }
        }
    }
}