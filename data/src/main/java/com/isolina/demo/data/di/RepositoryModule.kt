package com.isolina.demo.data.di

import com.isolina.demo.data.impl.RepositoryImpl
import com.isolina.demo.data.repository.Repository
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
    internal abstract fun bindRepository(repository: RepositoryImpl): Repository

}