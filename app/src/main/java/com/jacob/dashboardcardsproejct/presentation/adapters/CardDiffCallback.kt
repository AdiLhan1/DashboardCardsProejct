package com.jacob.dashboardcardsproejct.presentation.adapters

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.jacob.dashboardcardsproejct.data.network.entities.DashboardResponse

class CardDiffCallback: DiffUtil.ItemCallback<DashboardResponse>() {

    override fun areItemsTheSame(oldItem: DashboardResponse, newItem: DashboardResponse): Boolean = (oldItem.total == newItem.total)

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: DashboardResponse, newItem: DashboardResponse): Boolean = (oldItem == newItem)
}