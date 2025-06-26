package com.views.samplemvvmapp.di

import com.views.samplemvvmapp.network.MonstersService
import com.views.samplemvvmapp.repository.MonstersRepository
import com.views.samplemvvmapp.repository.implementation.MonstersRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideMonstersRepository(
        monstersService: MonstersService
    ): MonstersRepository {
        return MonstersRepositoryImpl(monstersService)
    }
}