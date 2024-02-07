package com.example.tbc_test8.data.remote.common

import android.util.Log
import com.example.tbc_test8.data.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class HandleResponse {
    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): Flow<Resource<T>> = flow {
        try {
            emit(Resource.Loading(true))
            val response = call()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                emit(Resource.Success(body))
            } else {
                emit(Resource.Error(response.errorBody()?.toString() ?: ""))
                Log.d("random error", response.errorBody().toString())
            }
        } catch (e: Throwable) {
            emit(Resource.Error(e.message ?: ""))
            Log.d("random error", e.message.toString())
        }
        emit(Resource.Loading(false))
    }
}