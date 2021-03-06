package com.jacob.dashboardcardsproejct.di

import com.jacob.dashboardcardsproejct.data.network.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideDashboardApiService() = RetrofitClient().provideDashboardApiService()
}