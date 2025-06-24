package com.views.samplemvvmapp.ui.monster_details

import com.views.samplemvvmapp.domain.MonsterDetails

data class MonsterDetailsState(
    val isLoading: Boolean = true,
    val details: MonsterDetails = MonsterDetails()
)
