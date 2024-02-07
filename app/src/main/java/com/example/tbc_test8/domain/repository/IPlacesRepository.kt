package com.example.tbc_test8.domain.repository

import com.example.tbc_test8.data.Resource
import com.example.tbc_test8.domain.model.Place
import kotlinx.coroutines.flow.Flow

interface IPlacesRepository {
    suspend fun getPlaces(): Flow<Resource<List<Place>>>
}