package com.example.tbc_test8.domain.use_case

import com.example.tbc_test8.data.Resource
import com.example.tbc_test8.domain.model.Place
import com.example.tbc_test8.domain.repository.IPlacesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPlacesUseCase @Inject constructor(private val repository: IPlacesRepository) {

    suspend operator fun invoke(): Flow<Resource<List<Place>>> {
        return repository.getPlaces()
    }
}