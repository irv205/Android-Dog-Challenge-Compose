package com.kk.dogchallengecompose.data.repository

import com.kk.dogchallengecompose.core.utils.ResponseHandler
import com.kk.dogchallengecompose.data.mapper.toDomainModel
import com.kk.dogchallengecompose.data.service.IService
import com.kk.dogchallengecompose.domain.model.Dog
import com.kk.dogchallengecompose.domain.repository.IRepository
import javax.inject.Inject

class RepositoryImp @Inject constructor(private val service: IService): IRepository {

    override suspend fun getDog(): ResponseHandler<Dog> {
        return try {
            ResponseHandler.Success(service.getDog().toDomainModel())
        } catch (e: Exception){
            ResponseHandler.Error(e.message.toString())
        }
    }
}