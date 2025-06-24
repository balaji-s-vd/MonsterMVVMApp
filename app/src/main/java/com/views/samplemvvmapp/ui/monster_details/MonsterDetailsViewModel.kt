package com.views.samplemvvmapp.ui.monster_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.views.samplemvvmapp.repository.MonstersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class MonsterDetailsViewModel (
    private val monstersRepository: MonstersRepository
): ViewModel() {
    private val _state = MutableStateFlow(MonsterDetailsState())
    val state = _state.asStateFlow()

    fun getMonsterDetails(index: String) {
        viewModelScope.launch {
            val details = monstersRepository.getMonsterDetails(index)

            _state.update {
                it.copy(
                    isLoading = false,
                    details = details
                )
            }
        }
    }
}