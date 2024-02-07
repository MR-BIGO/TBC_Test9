package com.example.tbc_test8.data.repository.remote

import com.example.tbc_test8.data.Resource
import com.example.tbc_test8.data.remote.common.HandleResponse
import com.example.tbc_test8.data.remote.mapper.mapListToDomain
import com.example.tbc_test8.data.remote.mapper.toDomain
import com.example.tbc_test8.data.remote.service.IPlacesService
import com.example.tbc_test8.domain.model.Place
import com.example.tbc_test8.domain.repository.IPlacesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PlacesRepositoryImpl @Inject constructor(
    private val service: IPlacesService,
    private val handler: HandleResponse
) : IPlacesRepository {
    override suspend fun getPlaces(): Flow<Resource<List<Place>>> {
        return handler.safeApiCall {
            service.getPlaces()
        }.mapListToDomain { it.toDomain() }
    }
}