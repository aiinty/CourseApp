package com.aiinty.data.di

import com.aiinty.data.network.CourseApi
import com.aiinty.data.repository.CourseRepositoryImpl
import com.aiinty.domain.repository.CourseRepository
import com.aiinty.domain.usecase.GetCoursesUseCase
import com.aiinty.domain.usecase.GetFavoriteCoursesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideCourseApi(retrofit: Retrofit): CourseApi =
        retrofit.create(CourseApi::class.java)

    @Provides
    @Singleton
    fun provideCourseRepository(impl: CourseRepositoryImpl): CourseRepository = impl

    @Provides
    @Singleton
    fun provideGetCoursesUseCase(repository: CourseRepository) = GetCoursesUseCase(repository)

    @Provides
    @Singleton
    fun provideGetFavoriteCoursesUseCase(repository: CourseRepository) = GetFavoriteCoursesUseCase(repository)
}