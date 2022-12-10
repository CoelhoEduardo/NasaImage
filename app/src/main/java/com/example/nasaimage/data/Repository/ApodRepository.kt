package com.example.nasaimage.data.Repository

import com.example.nasaimage.data.Network.ApodApi
import com.example.nasaimage.data.model.ApodData
import com.example.nasaimage.data.model.ApodResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class ApodRepository(private var apodApi: ApodApi = ApodApi.instance) {
    fun fetchApod(): Flow<ApodData> = flow {
        emit(apodApi.getApod())
    }.flowOn(Dispatchers.IO)

    companion object {
        val instances by lazy { ApodRepository() }
    }
}

class PictureRepository(private var apodApi: ApodApi = ApodApi.instance) {
    fun fetchPicture(): Flow<ApodResponse> = flow {
        emit(apodApi.getPicutres())
    }.flowOn(Dispatchers.IO)

    companion object {
        val instancesPic by lazy { PictureRepository() }
    }
}
