package com.kk.dogchallengecompose.data.service

import com.kk.dogchallengecompose.data.model.DogDTO
import retrofit2.http.GET

interface IService {

    @GET("random")
    suspend fun getDog(): DogDTO
}