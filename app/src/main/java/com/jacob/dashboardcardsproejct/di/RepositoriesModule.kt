package com.jacob.dashboardcardsproejct.di

import com.jacob.dashboardcardsproejct.data.network.apiservices.DashboardApiService
import com.jacob.dashboardcardsproejct.data.repositories.DashboardRepositoryImpl
import com.jacob.dashboardcardsproejct.domain.repositories.DashboardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoriesModule {

    @Provides
    fun provideDashboardRepository(service: DashboardApiService): DashboardRepository {
        return DashboardRepositoryImpl(service)
    }
}