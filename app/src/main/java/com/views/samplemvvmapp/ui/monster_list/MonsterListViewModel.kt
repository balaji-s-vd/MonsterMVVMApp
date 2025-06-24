package com.views.samplemvvmapp.ui.monster_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.views.samplemvvmapp.repository.MonstersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class MonsterListViewModel (
    private val monstersRepository: MonstersRepository
): ViewModel() {
    private val _state = MutableStateFlow(MonsterListState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val list = monstersRepository.getMonstersList()

            _state.update {
                it.copy(
                    isLoading = false,
                    list = list
                )
            }
        }
    }
}