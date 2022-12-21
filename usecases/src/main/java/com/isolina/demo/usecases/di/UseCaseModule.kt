package com.isolina.demo.usecases.di

import com.isolina.demo.usecases.UseCase
import com.isolina.demo.usecases.impl.UseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {
    @Binds
    @Singleton
    internal abstract fun bindUseCase(useCaseImpl: UseCaseImpl): UseCase

}