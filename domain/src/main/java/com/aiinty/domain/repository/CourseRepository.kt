package com.aiinty.domain.repository

import com.aiinty.domain.model.Course

interface CourseRepository {
    suspend fun getCourses(): List<Course>
    suspend fun getFavoriteCourses(): List<Course>
}