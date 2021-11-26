package com.jacob.dashboardcardsproejct.base

import androidx.lifecycle.ViewModel
import com.jacob.dashboardcardsproejct.common.resource.Resource
import com.jacob.dashboardcardsproejct.presentation.state.StateViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

abstract class BaseViewModel : ViewModel() {

    protected suspend fun <T> subscribeTo(
        state: StateViewModel<T>,
        request: () -> Flow<Resource<T>>
    ) {
        request().collect {
            state.isLoading.value = it is Resource.Loading
            when (it) {
                is Resource.Loading -> {
                }
                is Resource.Error -> {
                    it.message?.let { error ->
                        state.error.value = error
                    }
                }
                is Resource.Success -> {
                    it.data?.let { data ->
                        state.data.value = data
                    }
                }
            }
        }
    }
}