package com.views.samplemvvmapp.di

import com.views.samplemvvmapp.network.MonstersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://www.dnd5eapi.co/api/2014")
            .build()
    }

    @Provides
    @Singleton
    fun provideMonsterService(retrofit: Retrofit): MonstersService {
        return retrofit.create(MonstersService::class.java)
    }
}