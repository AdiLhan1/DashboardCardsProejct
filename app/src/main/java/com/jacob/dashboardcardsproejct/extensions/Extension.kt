package com.jacob.dashboardcardsproejct.extensions

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.jacob.dashboardcardsproejct.presentation.state.StatePresentation

fun <T> Fragment.subscribeTo(
    context: Context?,
    state: StatePresentation<T>,
    loader: ProgressBar,
    setupData: (T) -> Unit
) = with(state) {
    isLoading.observe(viewLifecycleOwner) {
        loader.isVisible = it
    }

    error.observe(viewLifecycleOwner) {
        context?.showToast(it)
    }

    data.observe(viewLifecycleOwner) {
        setupData(it)
    }
}

fun Context.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.snack(message: String, duration: Int = Snackbar.LENGTH_LONG) {
    Snackbar.make(this, message, duration).show()
}
