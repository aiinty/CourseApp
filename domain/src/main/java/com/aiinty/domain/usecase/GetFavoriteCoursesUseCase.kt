package com.aiinty.domain.usecase

import com.aiinty.domain.model.Course
import com.aiinty.domain.repository.CourseRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteCoursesUseCase(private val repository: CourseRepository) {
    operator fun invoke(): Flow<List<Course>> {
        return repository.getFavoriteCourses()
    }
}