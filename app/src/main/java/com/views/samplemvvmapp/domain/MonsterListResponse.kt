package com.views.samplemvvmapp.domain

data class MonsterListResponse(
    val count: Int,
    val results: List<MonsterListDetails>
)
