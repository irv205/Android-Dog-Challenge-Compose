package com.kk.dogchallengecompose.domain.repository

import com.kk.dogchallengecompose.core.utils.ResponseHandler
import com.kk.dogchallengecompose.domain.model.Dog

interface IRepository {
    suspend fun getDog(): ResponseHandler<Dog>
}