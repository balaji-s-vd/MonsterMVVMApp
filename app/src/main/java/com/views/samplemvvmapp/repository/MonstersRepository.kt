package com.views.samplemvvmapp.repository

import com.views.samplemvvmapp.domain.MonsterDetails
import com.views.samplemvvmapp.domain.MonsterListDetails

interface MonstersRepository {
    suspend fun getMonstersList(): List<MonsterListDetails>

    suspend fun getMonsterDetails(index: String): MonsterDetails
}