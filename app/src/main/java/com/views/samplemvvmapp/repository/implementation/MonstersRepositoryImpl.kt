package com.views.samplemvvmapp.repository.implementation

import android.util.Log
import com.views.samplemvvmapp.domain.MonsterDetails
import com.views.samplemvvmapp.domain.MonsterListDetails
import com.views.samplemvvmapp.network.MonstersService
import com.views.samplemvvmapp.repository.MonstersRepository
import javax.inject.Inject

class MonstersRepositoryImpl @Inject constructor (
    private val monstersService: MonstersService
) : MonstersRepository {
    override suspend fun getMonstersList(): List<MonsterListDetails> {
        return try {
            val response = monstersService.getMonstersList()
            response.results
        } catch (ex: Exception) {
            Log.i("TAG", "getMonstersList: $ex")
            emptyList<MonsterListDetails>()
        }
    }

    override suspend fun getMonsterDetails(index: String): MonsterDetails {
        return try {
            val response = monstersService.getMonsterDetails(index)
            response
        } catch (ex: Exception) {
            Log.i("TAG", "getMonstersList: $ex")
            MonsterDetails()
        }
    }
}