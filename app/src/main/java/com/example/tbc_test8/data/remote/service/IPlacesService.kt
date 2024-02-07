package com.example.tbc_test8.data.remote.service

import com.example.tbc_test8.data.remote.model.PlaceDto
import retrofit2.Response
import retrofit2.http.GET

interface IPlacesService {
    @GET("0545ddc1-c487-46ce-b70c-5b95270d6b76")
    suspend fun getPlaces(): Response<List<PlaceDto>>
}