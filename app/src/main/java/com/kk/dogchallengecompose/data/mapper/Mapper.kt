package com.kk.dogchallengecompose.data.mapper

import com.kk.dogchallengecompose.data.model.DogDTO
import com.kk.dogchallengecompose.domain.model.Dog

fun DogDTO.toDomainModel(): Dog = Dog(message)