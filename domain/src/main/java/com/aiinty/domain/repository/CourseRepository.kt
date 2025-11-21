package com.aiinty.domain.repository

import com.aiinty.domain.model.Course
import kotlinx.coroutines.flow.Flow

interface CourseRepository {

    fun getAllCourses(): Flow<List<Course>>

    fun getFavoriteCourses(): Flow<List<Course>>

    suspend fun toggleLike(courseId: Int, isFavorite: Boolean)

    suspend fun saveInitialCourses()

    suspend fun isDatabaseEmpty(): Boolean
}