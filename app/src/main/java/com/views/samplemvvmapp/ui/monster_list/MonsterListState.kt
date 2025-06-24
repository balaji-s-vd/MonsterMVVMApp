package com.views.samplemvvmapp.ui.monster_list

import com.views.samplemvvmapp.domain.MonsterListDetails

data class MonsterListState(
    val isLoading: Boolean = true,
    val list: List<MonsterListDetails> = emptyList()
)
