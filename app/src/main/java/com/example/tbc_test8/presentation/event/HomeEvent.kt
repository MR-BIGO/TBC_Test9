package com.example.tbc_test8.presentation.event

sealed class HomeEvent {
    data object ResetError : HomeEvent()
}