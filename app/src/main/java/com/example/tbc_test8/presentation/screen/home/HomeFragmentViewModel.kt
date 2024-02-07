package com.example.tbc_test8.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tbc_test8.data.Resource
import com.example.tbc_test8.domain.use_case.GetPlacesUseCase
import com.example.tbc_test8.presentation.event.HomeEvent
import com.example.tbc_test8.presentation.mapper.toPresentation
import com.example.tbc_test8.presentation.state.home.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(private val getPlacesUseCase: GetPlacesUseCase) : ViewModel() {

    private val _homeState = MutableStateFlow(HomeState())
    val homeState: SharedFlow<HomeState> = _homeState.asStateFlow()

    init {
        getPlaces()
    }

    fun onEvent(event: HomeEvent) {
        when(event){
            is HomeEvent.ResetError -> setError(null)
        }

    }

    private fun getPlaces() {
        viewModelScope.launch {
            getPlacesUseCase().collect {
                when (it) {
                    is Resource.Success -> {
                        _homeState.update { currentState ->
                            currentState.copy(
                                data = it.data.map { item -> item.toPresentation() }
                            )
                        }
                    }

                    is Resource.Loading -> {
                        _homeState.update { currentState -> currentState.copy(loading = it.loading) }
                    }

                    is Resource.Error -> setError(it.error)
                }
            }
        }
    }

    private fun setError(error: String?) {
        viewModelScope.launch {
            _homeState.update { currentState -> currentState.copy(error = error) }
        }
    }
}