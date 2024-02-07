package com.example.tbc_test8.presentation.state.home

import com.example.tbc_test8.presentation.model.PlacePresentation

data class HomeState(
    val data: List<PlacePresentation>? = null,
    val loading: Boolean = false,
    val error: String? = null
)