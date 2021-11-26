package com.jacob.dashboardcardsproejct.presentation.utils

import android.view.View
import com.jacob.dashboardcardsproejct.extensions.gone
import com.jacob.dashboardcardsproejct.extensions.visible


fun cardGoneView(vararg viewM: View) {
    viewM.forEach {
        it.gone()
    }
}

fun cardVisibleView(vararg viewM: View) {
    viewM.forEach {
        it.visible()
    }
}

