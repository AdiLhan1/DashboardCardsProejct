package com.jacob.dashboardcardsproejct.presentation.state

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class StateViewModel<T>(
    val isLoading: MutableLiveData<Boolean> = MutableLiveData(),
    val error: MutableLiveData<String> = MutableLiveData(),
    val data: MutableLiveData<T> = MutableLiveData()
)

class StatePresentation<T>(
    val isLoading: LiveData<Boolean>,
    val error: LiveData<String>,
    val data: LiveData<T>
)