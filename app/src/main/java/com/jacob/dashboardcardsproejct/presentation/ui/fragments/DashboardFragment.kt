package com.jacob.dashboardcardsproejct.presentation.ui.fragments

import androidx.fragment.app.viewModels
import com.jacob.dashboardcardsproejct.base.BaseEmptyFragment
import com.jacob.dashboardcardsproejct.data.network.entities.DashboardResponse
import com.jacob.dashboardcardsproejct.databinding.FragmentDashboardBinding
import com.jacob.dashboardcardsproejct.extensions.subscribeTo
import com.jacob.dashboardcardsproejct.presentation.adapters.DashboardCardsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment :
    BaseEmptyFragment<FragmentDashboardBinding>(FragmentDashboardBinding::inflate) {
    private val viewModel: DashboardViewModel by viewModels()

    private var adapter: DashboardCardsAdapter? = null

    private val listOfCards = mutableListOf<DashboardResponse>()

    override fun initialize() {
        adapter = DashboardCardsAdapter()
        binding.rvCards.adapter = adapter
    }

    private fun showData(response: DashboardResponse) {
        listOfCards.add(response)
        listOfCards.let { modelList ->
            adapter?.submitList(modelList)
        }
    }

    override fun setupObservers() {
        subscribeTo(context, viewModel.gradeState, binding.loaderMain) {
            showData(it)
        }
        subscribeTo(context, viewModel.refillState, binding.loaderMain) {
            showData(it)
        }
        subscribeTo(context, viewModel.profitState, binding.loaderMain) {
            showData(it)
        }
        subscribeTo(context, viewModel.bonusState, binding.loaderMain) {
            showData(it)
        }
    }
}