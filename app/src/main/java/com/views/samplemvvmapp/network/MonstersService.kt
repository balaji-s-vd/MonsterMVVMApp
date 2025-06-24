package com.views.samplemvvmapp.network

import com.views.samplemvvmapp.domain.MonsterDetails
import com.views.samplemvvmapp.domain.MonsterListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MonstersService {
    @GET("/monsters")
    suspend fun getMonstersList(): MonsterListResponse

    @GET("/monsters/{index}")
    suspend fun getMonsterDetails(
        @Path("index") index: String
    ): MonsterDetails
}