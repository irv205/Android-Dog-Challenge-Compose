package com.kk.dogchallengecompose.core.di

import com.kk.dogchallengecompose.data.repository.RepositoryImp
import com.kk.dogchallengecompose.domain.repository.IRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideRepository(repositoryImp: RepositoryImp): IRepository
}