package com.jacob.dashboardcardsproejct.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jacob.dashboardcardsproejct.data.network.entities.DashboardResponse
import com.jacob.dashboardcardsproejct.databinding.TopCardViewBinding
import com.jacob.dashboardcardsproejct.extensions.showToast
import com.jacob.dashboardcardsproejct.extensions.snack
import com.jacob.dashboardcardsproejct.presentation.utils.cardGoneView
import com.jacob.dashboardcardsproejct.presentation.utils.cardVisibleView

class DashboardCardsAdapter :
    ListAdapter<DashboardResponse, DashboardCardsAdapter.ViewHolder>(CardDiffCallback()) {

    inner class ViewHolder(private val binding: TopCardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(model: DashboardResponse) {
            with(binding) {
                getInfo.setOnClickListener {
                    root.context.showToast(model.about)
                }
                if (model.stock != null) {
                    topCard.setBackgroundResource(com.jacob.dashboardcardsproejct.R.drawable.card_bg)
                    cardGoneView(
                        refillAddBtn, withDrawnDesc, withDrawn, cardBalanceRubDesc,
                        cardBalanceRub, cardWithdrawnRub, cardWithdrawnRubDesc
                    )
                    cardVisibleView(imgCardRaise, containerGrade, cardRaise)
                    cardAmountDesc.text = "Оценка портфеля"
                    cardAmount.text = "${model.total} \$"
                    cardRaise.text = model.raise.toString() + "%"
                    stockAmount.text = model.stock.toString() + " \$"
                    balanceUsd.text = model.balanceUSD.toString() + " \$"
                    balanceRub.text = model.balanceRUB.toString() + " ₽"

                } else if (model.invest != null) {
                    topCard.setBackgroundResource(com.jacob.dashboardcardsproejct.R.drawable.card_profit_bg)
                    cardAmountDesc.text = "Прибыль с акций"
                    cardGoneView(containerGrade, withDrawnDesc, withDrawn, refillAddBtn)
                    cardVisibleView(cardRaise, imgCardRaise)
                    cardBalanceRubDesc.text = "Инвестировано"
                    cardRaise.text = model.raise.toString() + "%"
                    cardWithdrawnRubDesc.text = "Общая стоимость"
                    cardBalanceRub.text = model.invest.toString() + " \$"
                    cardWithdrawnRub.text = model.price.toString() + " \$"

                } else if (model.team != null) {
                    topCard.setBackgroundResource(com.jacob.dashboardcardsproejct.R.drawable.card_bonus_bg)
                    cardAmountDesc.text = "Ожидаемый бонус"
                    cardAmount.text = "${model.totalRUB}"
                    cardGoneView(containerGrade, withDrawn)
                    cardVisibleView(teamCount, teamImg, bonusRubBtn, bonusUsdBtn)
                    bonusRubBtn.setOnClickListener {
                        cardAmount.text = "${model.totalRUB}"
                        bonusUsdBtn.setBackgroundResource(com.jacob.dashboardcardsproejct.R.drawable.disable_btn_bg)
                        bonusRubBtn.setBackgroundResource(com.jacob.dashboardcardsproejct.R.drawable.enable_btn_bg)
                        bonusUsdBtn.setTextColor(
                            androidx.core.content.ContextCompat.getColor(
                                root.context,
                                com.jacob.dashboardcardsproejct.R.color.gray
                            )
                        )
                        bonusRubBtn.setTextColor(android.graphics.Color.BLACK)
                    }
                    bonusUsdBtn.setOnClickListener {
                        cardAmount.text = "${model.totalUSD}"
                        bonusRubBtn.setTextColor(
                            androidx.core.content.ContextCompat.getColor(
                                root.context,
                                com.jacob.dashboardcardsproejct.R.color.gray
                            )
                        )
                        bonusUsdBtn.setTextColor(android.graphics.Color.BLACK)
                        bonusRubBtn.setBackgroundResource(com.jacob.dashboardcardsproejct.R.drawable.disable_btn_bg)
                        bonusUsdBtn.setBackgroundResource(com.jacob.dashboardcardsproejct.R.drawable.enable_btn_bg)
                    }
                    refillAddBtn.setImageResource(com.jacob.dashboardcardsproejct.R.drawable.ic_add_user)
                    refillAddBtn.setOnClickListener {
                        it.snack("Пока вы не можете добавлять людей")
                    }
                    withDrawnDesc.text = "В команде"
                    cardBalanceRubDesc.text = "Пополнено RUB"
                    cardWithdrawnRubDesc.text = "Выведено RUB"
                    cardBalanceRub.text = model.refillRUB.toString() + " ₽"
                    cardWithdrawnRub.text = model.refillUSD.toString() + " ₽"
                    teamCount.text = model.team.toString()

                } else {
                    topCard.setBackgroundResource(com.jacob.dashboardcardsproejct.R.drawable.card_refill_bg)
                    cardGoneView(containerGrade, cardRaise, imgCardRaise)
                    cardAmountDesc.text = "Пополнено"
                    cardAmount.text = "${model.total} \$"
                    withDrawn.text = "${model.withdrawn} \$"
                    cardBalanceRub.text = model.refillRUB.toString() + " ₽"
                    cardWithdrawnRub.text = model.refillUSD.toString() + " ₽"
                    withDrawnDesc.text = "Выведено"
                    cardBalanceRubDesc.text = "Пополнено RUB"
                    cardWithdrawnRubDesc.text = "Выведено RUB"
                    refillAddBtn.setOnClickListener {
                        it.snack("Пока вы не можете пополнить счет")
                    }
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            TopCardViewBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

}