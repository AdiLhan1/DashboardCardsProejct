package com.jacob.dashboardcardsproejct.presentation.adapters

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.jacob.dashboardcardsproejct.data.network.entities.DashboardResponse

class CardDiffCallback : DiffUtil.ItemCallback<DashboardResponse>() {

    override fun areItemsTheSame(oldItem: DashboardResponse, newItem: DashboardResponse): Boolean =
        (oldItem.total  == newItem.total || oldItem.isSelected == newItem.isSelected )

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: DashboardResponse,
        newItem: DashboardResponse
    ): Boolean = (
            oldItem == newItem || oldItem.isSelected == newItem.isSelected )

    override fun getChangePayload(oldItem: DashboardResponse, newItem: DashboardResponse): Any? {
        return if (oldItem.isSelected != newItem.isSelected) true else null
    }
}