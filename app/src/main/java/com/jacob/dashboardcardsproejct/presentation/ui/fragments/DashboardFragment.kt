package com.jacob.dashboardcardsproejct.presentation.ui.fragments

import android.util.Log
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

    private var lastPos = -1

    override fun initialize() {
        adapter = DashboardCardsAdapter(this::toggleSelectedStatus)
        binding.rvCards.adapter = adapter
    }

    private fun toggleSelectedStatus(id: String, isSelected: Boolean, position: Int) {
        Log.e("TAG", "toggleSelectedStatus: TOtal: $id Status: $isSelected")
        if (lastPos != -1 && lastPos != position) {
            listOfCards[lastPos].isSelected = false
            adapter?.notifyItemChanged(lastPos)
        }
        listOfCards[position].isSelected = true
        lastPos = position
        adapter?.notifyItemChanged(position)

        adapter?.submitList(listOfCards)
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