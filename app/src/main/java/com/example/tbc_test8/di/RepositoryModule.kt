package com.example.tbc_test8.di

import com.example.tbc_test8.data.remote.common.HandleResponse
import com.example.tbc_test8.data.remote.service.IPlacesService
import com.example.tbc_test8.data.repository.remote.PlacesRepositoryImpl
import com.example.tbc_test8.domain.repository.IPlacesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePlacesRepository(service: IPlacesService, handleResponse: HandleResponse):IPlacesRepository{
        return PlacesRepositoryImpl(service, handleResponse)
    }

    @Singleton
    @Provides
    fun provideHandleResponse(): HandleResponse {
        return HandleResponse()
    }
}